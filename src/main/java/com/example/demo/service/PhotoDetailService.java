package com.example.demo.service;

import com.example.demo.model.PhotoDetail;

import java.util.List;

public interface PhotoDetailService {
    void addPhototDetail(List<PhotoDetail> photoDetail);
    List<PhotoDetail> findPhotoDetail(PhotoDetail photoDetail);
}
