package com.dao;

import entity.BeuserEntity;
import service.IUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Mezereon on 2017/10/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class SprintHibernateTest {
    @Autowired
    private IUserServiceImpl userService;

    @Test
    public void test() {
        List<BeuserEntity> userList = userService.getAllUser();
        for(BeuserEntity user:userList){
            System.out.println("ID号：" + user.getId() + "；用户名：" + user.getUsername() +
                    "；密码：" + user.getPassword() + "；邮件：" + user.getEmail());
        }
    }

    @Test
    public void testLogin(){
        System.out.println(userService.isExists("saber"));
    }
}
