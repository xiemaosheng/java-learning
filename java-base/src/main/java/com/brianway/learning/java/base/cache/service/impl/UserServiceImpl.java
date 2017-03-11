package com.brianway.learning.java.base.cache.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.brianway.learning.java.base.cache.dao.UserDao;
import com.brianway.learning.java.base.cache.model.User;
import com.brianway.learning.java.base.cache.service.UserSaveCache;
import com.brianway.learning.java.base.cache.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
//    @CacheEvict(value = "data",allEntries = true,key = "#user.id + 'add'")
//    @CachePut(value = "data",key = "#user.id +'add'")
    @UserSaveCache
    public User add(User user) {
        System.out.println("UserService: method - add(User user)");
        userDao.add(user);
        return user;
    }

    @Override
    @CacheEvict(value = "data",allEntries = true,key = "#id")
//    @CachePut(value = "data",key = "#user.id")
    public void delete(String id) {
        System.out.println("UserService: method - delete(String id)");
        userDao.delete(id);
    }

    @Override
    @CacheEvict(value = "data",allEntries = false,key = "#user.id")
//    @CachePut(value = "data",key = "#user.id +'update'")
    public void update(User user) {
        System.out.println("UserService: method - update(User user)");
        userDao.update(user);
        //方法内部不生效
        findTest(user.getId());
    }

    @Override
    @Cacheable(value = "data",condition = "#id.length() >0",key = "#id")
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
