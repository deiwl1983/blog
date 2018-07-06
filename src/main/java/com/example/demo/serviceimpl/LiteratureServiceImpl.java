package com.example.demo.serviceimpl;

import com.example.demo.dao.LiteratureDao;
import com.example.demo.model.Literature;
import com.example.demo.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LiteratureServiceImpl implements LiteratureService {


    @Autowired
    LiteratureDao literatureDao;
    @Override
    @Transactional
    public List<Literature> listLiteraturePage(String desc) {
        List<Literature> literature = literatureDao.listLiteraturePage(desc);
        return literature;
    }
}
