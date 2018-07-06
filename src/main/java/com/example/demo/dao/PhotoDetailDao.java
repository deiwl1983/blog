package com.example.demo.dao;

import com.example.demo.model.PhotoDetail;

import java.util.List;

public interface PhotoDetailDao {

    public void uploadPhoto(List<PhotoDetail> photoDetail );

    List<PhotoDetail> findPhotoDetail(PhotoDetail photoDetail);
}
