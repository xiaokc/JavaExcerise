package com.dao;

import com.po.Users;

/**
 * Created by xkc on 8/19/15.
 * 封装用户的业务逻辑类 javabeans
 */
public class UsersDao {

    //实际上应该使用数据库，这里简单判断如果用户名和密码如果都是admin，则认为是合法用户
    public boolean usersLogin(Users users){
        if (users.getUsername().equals("admin") && users.getPassword().equals("admin")){
            return true;
        }else {
            return false;
        }
    }
}
