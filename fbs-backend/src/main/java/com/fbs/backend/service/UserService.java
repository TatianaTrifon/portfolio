package com.fbs.backend.service;

import com.fbs.backend.domain.User;

public interface UserService {
  User createUser(User user);

  User updateUser(User user);

  boolean deleteUserById(Integer id);

  User findUserById(Integer id);

  User findUserByEmail(String email);
}
