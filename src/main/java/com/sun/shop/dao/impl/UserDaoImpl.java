package com.sun.shop.dao.impl;

import com.sun.shop.dao.UserDao;
import com.sun.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ddyunf on 2018/7/16.
 * @author ddyunf
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        User userInfo = jdbcTemplate.queryForObject(sql, new User(),
                new Object[] { id });

        return userInfo;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user ";
        return jdbcTemplate.query(sql,new User());
    }

    @Override
    public Integer save(User entity) {
        String sql = "INSERT INTO user(name, age, registerTime) VALUES(:name, :age, :registerTime)";
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("name", entity.getName());
        paramSource.addValue("age", entity.getAge());
        paramSource.addValue("registerTime", entity.getRegisterTime());
        int result = namedParameterJdbcTemplate.update(sql, paramSource);

        return result;
    }
}
