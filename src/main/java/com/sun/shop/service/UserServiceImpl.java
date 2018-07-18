package com.sun.shop.service;

import com.sun.shop.dao.UserDao;
import com.sun.shop.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ddyunf on 2018/7/16.
 * @author ddyunf
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    @Resource
    private UserDao userDao;
    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Integer save(User userInfo) {
        return userDao.save(userInfo);
    }
}
