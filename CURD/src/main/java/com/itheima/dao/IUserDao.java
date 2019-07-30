package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    //该接口当有增加的方法
   void saveUser(User user);
   //该接口当有删除的方法
    void deleteUser(int id);
    //该接口当有更新方法
    void updateUser(User user);
    //该接口当有查询方法
    List<User> selectUser();
    //该接口当有根据id查询的方法
    User selectById(int id);
    //模糊查询
    List<User> findByName(String name);
    //查询总用户数
    Integer totalUser();
}
