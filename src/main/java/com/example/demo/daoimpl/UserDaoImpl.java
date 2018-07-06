package com.example.demo.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.demo.command.UserinfoCommand;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserInfo;
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public UserInfo findUser(String username) {
	
		String hql = "from UserInfo where name = ?";// + username;
		
		Query query = entityManager.createQuery(hql);
		query.setParameter(0, username);
		List<UserInfo> list=query.getResultList();
		if(!list.isEmpty()) {
			return list.get(0);
		}
		return null ;
	}

	@Override
	public UserInfo findUserById(Long userId) {

		return entityManager.find(UserInfo.class,userId);
	}

	@Override
	public void updatePwd(UserInfo user) {
		entityManager.merge(user);
	}

	@Override
	public void updateUserInfo(Long userId , UserinfoCommand cmd) {
		UserInfo u=entityManager.find(UserInfo.class,userId);
		u.setNickname(cmd.getNickname());
		u.setName(cmd.getName());
		u.setLoginTime(cmd.getNewDate());
		entityManager.persist(u);
	}

}
