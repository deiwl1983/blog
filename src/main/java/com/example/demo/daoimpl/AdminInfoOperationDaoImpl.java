package com.example.demo.daoimpl;

import com.example.demo.command.AdminOperationCommand;
import com.example.demo.dao.AdminInfoOpetationDao;
import com.example.demo.model.UserInfo;
import com.example.demo.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class AdminInfoOperationDaoImpl implements AdminInfoOpetationDao {
    @Autowired
    EntityManager entityManager;
    @Override
    public PageBean findUserInfoOperation(AdminOperationCommand cmd) {
        List<Object> params = new ArrayList<>();
        StringBuffer queryBuf = new StringBuffer("from UserInfo u where 1=1 ");
        StringBuffer countQueryBuf = new StringBuffer("select count(u.id) from UserInfo u where 1=1 ");
        StringBuffer where  = new StringBuffer();

        if (cmd.getName()!=null && !cmd.getName().equals("")){
            where.append(" and u.name like ? ");
            params.add("%"+cmd.getName()+"%");
        }
        if (cmd.getNickName()!=null && !cmd.getNickName().equals("")){
            where.append(" and u.nickname like ? ");
            params.add("%"+cmd.getNickName()+"%");
        }
        Query countQuery = entityManager.createQuery(countQueryBuf.append(where).toString());
        Query query = entityManager.createQuery(queryBuf.append(where).toString());
        Stream.of(countQuery,query).forEach((Query q) ->{
            int i=0;
            for(Object param :params){
                q.setParameter(i,param);
                i++;
            }
        });

        Long count = (Long) countQuery.getSingleResult();
        List<UserInfo> ret=query.setFirstResult(cmd.getStart()).setMaxResults(cmd.getLength()).getResultList();
        PageBean<UserInfo> pageBean = new PageBean<>(ret,count);
        return pageBean;
    }
}
