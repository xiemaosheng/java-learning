package com.brianway.learning.java.base.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Caching(
        cacheable = {
                @Cacheable(value = "data",key = "#user.username"),
        }
)
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UserFindCacheByName {
}
