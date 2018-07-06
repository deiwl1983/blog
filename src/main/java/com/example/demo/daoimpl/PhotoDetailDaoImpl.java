package com.example.demo.daoimpl;

import com.example.demo.dao.PhotoDetailDao;
import com.example.demo.model.PhotoDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PhotoDetailDaoImpl implements PhotoDetailDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void uploadPhoto(List<PhotoDetail> photoDetail) {
//        String sql ="insert into PhotoDetail ";
       for(PhotoDetail pd: photoDetail){
           entityManager.persist(pd);
       }


    }

    @Override
    public List<PhotoDetail> findPhotoDetail(PhotoDetail photoDetail) {
//        String hql ="from PhotoDetail where photoDetail = ?";
//        Query query = entityManager.createQuery(hql);
//        query.setParameter(0,photoDetail);
//        List<PhotoDetail> resultList = query.getResultList();
//        entityManager.find(PhotoDetail.class,);
//        return resultList;
        Query query = entityManager.createQuery("from PhotoDetail");
        List resultList = query.getResultList();
        return resultList;
    }
}
