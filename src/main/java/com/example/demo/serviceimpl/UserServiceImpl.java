package com.example.demo.serviceimpl;

import com.example.demo.command.UserinfoCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserInfo findUser(String username) {
		
		return userDao.findUser(username);
	}

	@Override
	public UserInfo findUserById(Long userId) {
		return userDao.findUserById(userId);
	}

	@Override
	@Transactional
	public void updatePwd(UserInfo user) {
		 userDao.updatePwd(user);
	}

	@Override
	@Transactional
	public void updateUserInfo(Long userId, UserinfoCommand cmd) {
		userDao.updateUserInfo(userId,cmd);
	}

}
