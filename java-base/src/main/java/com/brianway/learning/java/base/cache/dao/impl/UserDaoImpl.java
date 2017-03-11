package com.brianway.learning.java.base.cache.dao.impl;

import com.brianway.learning.java.base.cache.dao.UserDao;
import com.brianway.learning.java.base.cache.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public class UserDaoImpl implements UserDao {
    private Map<String,User> users = new HashMap<>();

    @Override
    public void add(User user) {
        System.out.println("UserDao method - add(User user)");
        users.put(user.getId(),user);
    }

    @Override
    public void delete(String id) {
        System.out.println("UserDao method - delete(String id)");
        users.remove(id);
    }

    @Override
    public void update(User user) {
        System.out.println("UserDao method - update(User user)");
        users.put(user.getId(),user);
    }

    @Override
    public User find(String id) {
        System.out.println("UserDao method - find(String id)");
        return users.get(id);
    }

    @Override
    public Map<String, User> getAll() {
        System.out.println("UserDao method - getAll()");
        return users;
    }
}
