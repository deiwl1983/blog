package com.example.demo.service;

import com.example.demo.command.AdminOperationCommand;
import com.example.demo.vo.PageBean;

public interface AdminOperationService {

    PageBean findUserInfoOperation(AdminOperationCommand cmd);
}
