package com.example.demo.service;

import com.example.demo.model.Literature;

import java.util.List;

public interface LiteratureService {
    List<Literature> listLiteraturePage(String desc);
}
