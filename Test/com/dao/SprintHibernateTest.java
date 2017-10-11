package com.dao;

import entity.BeuserEntity;
import service.IUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
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

    String sign = "你好";
    @Test
    public void test() {
        List<BeuserEntity> userList = userService.getAllUser();
        for(BeuserEntity user:userList){
            System.out.println("ID号：" + user.getId() + "；用户名：" + user.getUsername() +
                    "；密码：" + user.getPassword() + "；签名：" + user.getSignatrue());
        }
    }
    @Test
    public void testRegister(){

        try {
            sign = new String(sign.getBytes("GBK"),"utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BeuserEntity entity = new BeuserEntity();
        entity.setUsername("hello");
        entity.setEmail("1@qq.com");
        entity.setPassword("123456789");
        entity.setPhone("15804032451");
        entity.setSex("男");
        entity.setSignatrue(sign);
        entity.setSrc("http://mezereon.gotoip2.com/simple.jpg");
        try {
            userService.addUser(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testLogin(){
        System.out.println(userService.isExists("saber"));
    }
}
