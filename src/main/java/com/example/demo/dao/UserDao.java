package com.example.demo.dao;

import com.example.demo.command.UserinfoCommand;
import com.example.demo.model.UserInfo;

public interface UserDao {

	UserInfo findUser(String username);

    UserInfo findUserById(Long userId);

    void updatePwd(UserInfo user);

    void updateUserInfo(Long userId,UserinfoCommand cmd);
}
