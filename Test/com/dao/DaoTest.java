package com.dao;

import entity.BeuserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Mezereon on 2017/9/24.
 */
public class DaoTest {
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    @Before
    public void init() {
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    @Test
    public void testNewMethod(){
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = cb.createQuery(BeuserEntity.class);
        Root<BeuserEntity> root = criteriaQuery.from(BeuserEntity.class);
        criteriaQuery.select(root);
        TypedQuery<BeuserEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<BeuserEntity> list = typedQuery.getResultList();
        for(BeuserEntity user:list){
            System.out.println("ID号：" + user.getId() + "；用户名：" + user.getUsername() +
                    "；密码：" + user.getPassword() + "；邮件：" + user.getEmail());
        }
    }

    //增加
    @Test
    public void insert() {
        BeuserEntity ue = new BeuserEntity();
        ue.setUsername("Anny");
        ue.setPassword("123");
        ue.setEmail("Anny@163.com");
        session.save(ue);
        tx.commit();
    }
    //修改
    @Test
    public void update() {
        BeuserEntity user = (BeuserEntity) session.get(BeuserEntity.class, new Integer(2));
        user.setUsername("Penny");
        session.update(user);
        tx.commit();
        session.close();
    }
    //查找
    @Test
    public void getById() {
        BeuserEntity user = (BeuserEntity) session.get(BeuserEntity.class, new Integer(1));
        tx.commit();
        session.close();
        System.out.println("ID号：" + user.getId() + "；用户名：" + user.getUsername() +
                "；密码：" + user.getPassword() + "；邮件：" + user.getEmail());
    }
    //删除
    @Test
    public void delete() {
        BeuserEntity user = (BeuserEntity) session.get(BeuserEntity.class, new Integer(1));
        session.delete(user);
        tx.commit();
        session.close();
    }
}