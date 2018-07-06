package com.example.demo.controllers;

import com.example.demo.command.AdminOperationCommand;
import com.example.demo.command.UserCommand;
import com.example.demo.service.AdminOperationService;
import com.example.demo.vo.PageBean;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "admin/adminOperation")
public class AdminOperationController {
    @Autowired
    AdminOperationService aoservice;
//    EntityManager entityManager;
    /**
     * admin/adminOperation/adminInfo
     * 跳转
     * @param request
     * @return
     */
    @RequestMapping(value = "adminInfo")
    public String adminOperation(HttpServletRequest request,Model model){

        return "adminManager/adminOperation";
    }

    @RequestMapping(value = "findUserInfo")
    @ResponseBody
    public PageBean findUserInfo(AdminOperationCommand cmd){
        PageBean pageBean = aoservice.findUserInfoOperation(cmd);
        return pageBean;
    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping(value="addAdmin")
    public String addAdmin(UserCommand uc){
        return "adminManager/addUserInfo";
    }

    @RequestMapping(value = "editUserInfo")
    public String editUserInfo(UserCommand uc){

        return "";
    }
}
