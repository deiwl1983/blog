package com.example.demo.photo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.command.UserinfoCommand;
import com.example.demo.enums.LiteratureEnum;
import com.example.demo.model.Literature;
import com.example.demo.model.PhotoDetail;
import com.example.demo.model.UserInfo;
import com.example.demo.service.LiteratureService;
import com.example.demo.service.PhotoDetailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping(value="admin/photo")
public class UploadPhotoController {
	@Autowired
	UserService userService;
    @Autowired
    PhotoDetailService photoDetailService;

    @Autowired
	LiteratureService literatureService;
	/***
	 * 跳转页面
	 * @return
	 */
	@RequestMapping(value="upImg")
	public String uploadPhoto() {
		
		
		return "photo/uploadPhoto";
	}
	/**
	 * 上传图片
	 * @param request
	 * @return
	 */
	@RequestMapping(value="img")
	@ResponseBody
	public Map uploadImg(MultipartHttpServletRequest request) {
		
//		MultiValueMap<String,MultipartFile> map = request.getMultiFileMap();
//		String extName = null;
//		byte[] fileContent = new byte[0];
//		for(List<MultipartFile> l:map.values()) {
//			MultipartFile f = l.get(0);
//			extName = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));
//			try {
//				fileContent = f.getBytes();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

        Map ret=new HashMap();
		List<String> filesList=new ArrayList<>();
		Iterator<Map.Entry<String, MultipartFile>> iterator = request.getFileMap().entrySet().iterator();
		List<PhotoDetail> lp = new ArrayList<PhotoDetail>();
		while(iterator.hasNext()){
			Map.Entry<String, MultipartFile>  entry= iterator.next();
//			String filename=entry.getKey();
			String filename=entry.getValue().getOriginalFilename();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String ext=".jpg";
			if(filename.lastIndexOf('.')!=-1){
				ext=filename.substring(filename.lastIndexOf('.'));
			}
			String newFileName=sdf.format(new Date())+ext;
			String filePath="/jsp/upload/"+newFileName;
			filesList.add(filePath);
			PhotoDetail pd = new PhotoDetail();
			pd.setPath(filePath);
			pd.setTitle(filename);
			lp.add(pd);
			String absfilePath=request.getServletContext().getRealPath(filePath);

			try {
                /**MultipartFile.transferTo()
                 *  接收到的文件转移到给定的目标文件。
                 */

				entry.getValue().transferTo(new File(absfilePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        photoDetailService.addPhototDetail(lp);
		ret.put("list",filesList);
		return ret;
	}


	@RequestMapping(value = "showImg")
	public String showImg(HttpServletRequest request, HttpServletResponse response,Model model){
		PhotoDetail photoDetail = new PhotoDetail();
		List<PhotoDetail> photoList =photoDetailService.findPhotoDetail(null);
		model.addAttribute("photoList",photoList);
//		model.addAttribute("");

		return "photo/myphoto";
	}

	@RequestMapping(value = "literature")
	public String literature(Model model){
		List<Literature> literatureList =literatureService.listLiteraturePage(null);
		model.addAttribute("literatureList",literatureList);

		return "photo/literature";
	}

	@RequestMapping(value = "literatureList")
	public String listLiterature(HttpServletRequest request, @RequestParam(value ="target",required = false) String target, Model model ){

		LiteratureEnum anEnum;
		String desc =null;
		switch (target){
			case "1":
//				System.out.println("");
				anEnum= LiteratureEnum.getEnum(Integer.valueOf(target));
				desc = anEnum.getDesc();
				break;
			case "2":
				System.out.println("欣赏");
				anEnum = LiteratureEnum.getEnum(Integer.valueOf(target));
				 desc = anEnum.getDesc();
				break;
			case "3":
				System.out.println("程序人生");
				 anEnum = LiteratureEnum.getEnum(Integer.valueOf(target));
				 desc = anEnum.getDesc();
				break;
			case "4":
				System.out.println("经典语录");
				 anEnum = LiteratureEnum.getEnum(Integer.valueOf(target));
				 desc = anEnum.getDesc();
				break;
		}
		List<Literature> literatureList =literatureService.listLiteraturePage(desc);
		model.addAttribute("literatureList",literatureList);
		return "photo/literature";
	}
	@RequestMapping(value = "editeLiterature")
	public String editeLiterature(Model model){
		return "";
	}

	@RequestMapping(value="editInfo")
	public String editeInfo(Model model){

		return "photo/editAdmin";
	}
	@RequestMapping(value="updateInfo")
	@ResponseBody
	public Object updateInfo(HttpSession session, UserinfoCommand cmd){
		Map<String,Object> map = new HashMap<String,Object>();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		Object flag = 0;
		if(userInfo !=null){
			if(cmd.getPassword().equals(cmd.getCofirm())){

				userService.updateUserInfo(userInfo.getId(),cmd);
			}
			flag=1;
		}
		map.put("map",1);
		return map;
	}
}
