package com.example.demo.daoimpl;

import com.example.demo.dao.LiteratureDao;
import com.example.demo.model.Literature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LiteratureDaoImpl implements LiteratureDao {

    @Autowired
    EntityManager entityManager;
    @Override
    public List<Literature> listLiteraturePage(String desc) {
        String hql;
        Query query;
        List<Literature>   resultList;
        if(StringUtils.isEmpty(desc) ){
            hql = "from Literature";
            query  = entityManager.createQuery(hql);
            resultList = query.getResultList();
        }else {
            hql = "from Literature  where big_title =?";
//        String sql ="select l from Literature l where l. bitTitel ="+desc;
//        Query query = entityManager.createQuery(String.format("select l from Literature l where l. bitTitel =%s", desc));
            query = entityManager.createQuery(hql);
            query.setParameter(0, desc);
            resultList = query.getResultList();
        }
        return resultList;
    }
}
