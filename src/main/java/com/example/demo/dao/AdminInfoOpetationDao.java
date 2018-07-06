package com.example.demo.dao;

import com.example.demo.command.AdminOperationCommand;
import com.example.demo.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public interface AdminInfoOpetationDao {
   PageBean findUserInfoOperation(AdminOperationCommand cmd);
}
