package com.example.demo.service;

import com.example.demo.command.UserinfoCommand;
import com.example.demo.model.UserInfo;

public interface UserService {

	UserInfo findUser(String username);


    UserInfo findUserById(Long aLong);

    void updatePwd(UserInfo user);

    void updateUserInfo(Long userId, UserinfoCommand cmd);
}
