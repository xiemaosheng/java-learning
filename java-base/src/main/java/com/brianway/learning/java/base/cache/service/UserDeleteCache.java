package com.brianway.learning.java.base.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Caching(
        evict = {
            @CacheEvict(value = "data",key = "#user.id"),
            @CacheEvict(value = "data",key = "#user.username")
        }
)
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UserDeleteCache {
}
