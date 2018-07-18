package com.sun.shop.entity;

import com.sun.javafx.beans.IDProperty;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Generated;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by ddyunf on 2018/7/16.
 * @author ddyunf
 */

public class User implements RowMapper<User> ,Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private Date registerTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Date getRegisterTime() {
        return registerTime;
    }
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User userInfo = new User();
        userInfo.setId(rs.getInt("id"));
        userInfo.setName(rs.getString("name"));
        userInfo.setAge(rs.getInt("age"));
        userInfo.setRegisterTime(rs.getDate("registerTime"));
        return userInfo;
    }
}
