package com.sun.shop.service;

import com.sun.shop.entity.User;

import java.util.List;

/**
 * Created by ddyunf on 2018/7/16.
 */
public interface UserService {
    // 通过Id查询UserInfo
    User getById(Integer id);

    // 查询全部的UserInfo
    List<User> findAll();

    // 添加UserInfo
    Integer save(User userInfo);
}
