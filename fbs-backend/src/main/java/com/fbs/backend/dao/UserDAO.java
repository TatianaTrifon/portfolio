package com.fbs.backend.dao;

import com.fbs.backend.domain.User;

public interface UserDAO extends DAO<User> {

  User create(User user);

  User update(User user);

  boolean deleteById(Integer id);

  User findById(Integer id);

  User findByEmail(String email);
}
