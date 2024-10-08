package com.fbs.backend.dao;

import java.sql.SQLException;

public interface DAO<T> {

  T create(T t);

  T update(T t);

  boolean deleteById(Integer id);

  T findById(Integer id);
}
