package com.example.demo.serviceimpl;

import com.example.demo.command.AdminOperationCommand;
import com.example.demo.dao.AdminInfoOpetationDao;
import com.example.demo.service.AdminOperationService;
import com.example.demo.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminOperationServiceImpl implements AdminOperationService {
    @Autowired
    AdminInfoOpetationDao adminInfoOpetationDao;
    @Override
    @Transactional
    public PageBean findUserInfoOperation(AdminOperationCommand cmd) {

        return adminInfoOpetationDao.findUserInfoOperation(cmd);
    }
}
