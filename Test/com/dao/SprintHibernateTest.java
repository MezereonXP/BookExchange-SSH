package com.dao;

import entity.BeuserEntity;
import entity.BookarticleEntity;
import service.IBookArticleServiceImpl;
import service.IUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mezereon on 2017/10/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class SprintHibernateTest {
    @Autowired
    private IUserServiceImpl userService;

    @Autowired
    private IBookArticleServiceImpl bookArticleService;

    @Test
    public void test() {
        List<BeuserEntity> userList = userService.getAllUser();
        for(BeuserEntity user:userList){
            System.out.println("ID号：" + user.getId() + "；用户名：" + user.getUsername() +
                    "；密码：" + user.getPassword() + "；邮件：" + user.getEmail());
        }
    }

    @Test
    public void testAdd() throws SQLException {
        BeuserEntity beuserEntity=new BeuserEntity();
        beuserEntity.setUsername("caster");
        beuserEntity.setSrc("http://mezereon.gotoip2.com/simple.jpg");
        beuserEntity.setEmail("857547214@qq.com");
        beuserEntity.setPhone("13032494890");
        beuserEntity.setSex("男");
        beuserEntity.setPassword("123456789");
        beuserEntity.setSignatrue("这个人很懒!");
        userService.addUser(beuserEntity);
    }

    @Test
    public void testLogin() throws SQLException {
        System.out.println(userService.isExists("saber"));
//        List<BookarticleEntity> bookarticleEntities = bookArticleService.getAllBookArticle();
//        for(BookarticleEntity entity:bookarticleEntities){
//            System.out.println(entity.getTitle());
//        }
    }
}
