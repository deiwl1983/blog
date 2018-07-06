package com.example.demo.dao;

import com.example.demo.model.Literature;

import java.util.List;

public interface LiteratureDao {

    List<Literature> listLiteraturePage(String desc);
}
