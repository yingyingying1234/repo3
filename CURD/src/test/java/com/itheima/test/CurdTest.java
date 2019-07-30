package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class CurdTest {
    private InputStream in;

    private SqlSession session;
    private IUserDao userDao;
    @Before
    public void init() throws Exception{
    in = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    session = factory.openSession();
    userDao = session.getMapper(IUserDao.class);
    }
    @After
    public void destory() throws Exception{
        in.close();
        session.close();
    }
    //测试添加功能
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUsername("小白 ");
        user.setAddress("上海");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
        session.commit();
    }
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(5);
        session.commit();
    }
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("小黑");
        user.setAddress("北京");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setId(3);
        userDao.updateUser(user);
        session.commit();
    }
    @Test
    public void testselectUser(){
       List<User> users = userDao.selectUser();
       for (User user:users){
           System.out.println(user);
       }
    }
    @Test
    public void testselectById(){
        User user=userDao.selectById(2);
        System.out.println(user);
    }

    @Test
    public void testtotalUser(){
        int a = userDao.totalUser();
        System.out.println(a);
    }
}
