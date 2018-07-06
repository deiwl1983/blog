package com.example.demo.serviceimpl;

import com.example.demo.dao.PhotoDetailDao;
import com.example.demo.model.PhotoDetail;
import com.example.demo.service.PhotoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PhotoDetailServiceImpl implements PhotoDetailService {
    @Autowired
    PhotoDetailDao photoDetailDao;
    @Override
    @Transactional
    public void addPhototDetail(List<PhotoDetail> photoDetail) {
        photoDetailDao.uploadPhoto(photoDetail);
    }

    @Override
    @Transactional
    public List<PhotoDetail> findPhotoDetail(PhotoDetail photoDetail) {
        List<PhotoDetail> list=photoDetailDao.findPhotoDetail(photoDetail);
        return list;
    }
}
