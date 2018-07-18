package com.sun.shop.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ddyunf on 2018/7/16.
 * @author ddyunf
 */
public interface BaseDao<T, PK extends Serializable> {

    T getById(PK id);

    List<T> findAll();

    PK save(T entity);
}
