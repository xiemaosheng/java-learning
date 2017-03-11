package com.brianway.learning.java.base.cache.dao;

import com.brianway.learning.java.base.cache.model.User;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
public interface UserDao {
    void add(User user);

    void delete(String id);

    void update(User user);

    User find(String id);

    Map<String,User> getAll();
}
