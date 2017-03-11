package com.brianway.learning.java.base.cache.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.brianway.learning.java.base.cache.dao.UserDao;
import com.brianway.learning.java.base.cache.model.User;
import com.brianway.learning.java.base.cache.service.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class UserServiceImpl01 implements UserService01 {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @UserSaveCache
    public User add(User user) {
        System.out.println("UserService: method - add(User user)");
        userDao.add(user);
        return user;
    }

    @Override
    @UserDeleteCache
    public User delete(String id) {
        System.out.println("UserService: method - delete(String id)");
        User user = find(id);
        userDao.delete(id);
        return user;
    }

    @Override
    @UserUpdateCache
    public User update(User user) {
        System.out.println("UserService: method - update(User user)");
        userDao.update(user);
        //方法内部不生效
        findTest(user.getId());
        return user;
    }

    @Override
    @UserFindCacheById
    public User find(String id) {
        System.out.println("UserService: method - find(String id)");
        return userDao.find(id);
    }

    @Override
    @CachePut(value = "data",condition = "#id.length() >0",key = "#id")
    public User findTest(String id) {
        System.out.println("UserService: method - findTest(String id)");
        return userDao.find(id);
    }

    @Override
    @Cacheable(value = "data")
    public Map<String, User> getAll() {
        System.out.println("UserService: method - findAll()");
        return userDao.getAll();
    }

    @Override
    @Cacheable(value = "data")
    public JSONArray test(String id,JSONArray jsonArray) {
        System.out.println("UserService: method - test(User user)");
        return jsonArray;
    }
}
