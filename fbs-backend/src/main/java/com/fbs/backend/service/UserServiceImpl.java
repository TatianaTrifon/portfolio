package com.fbs.backend.service;

import com.fbs.backend.domain.User;
import com.fbs.backend.dao.UserDAO;
import com.fbs.backend.dao.UserDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
  private final UserDAO userDAO;

  public UserServiceImpl(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public User createUser(User user) {
     userDAO.create(user);
     return user;
  }

  @Override
  public User updateUser(User user) {
    if (user.getId() == null) {
      return userDAO.create(user);
    } else {
      return userDAO.update(user);
    }
  }

  @Override

  public boolean deleteUserById(Integer id) {
    if (id == null) {
      LOGGER.error("Failed to delete user with id: " + id);
      return false;
    } else {
      return userDAO.deleteById(id);
      }
  }

  @Override
  public User findUserById(Integer id) {

    if (id == null) {
      return null;
    }

    User user = userDAO.findById(id);

    if (user == null || user.getId() == null ) {
      LOGGER.error("Couldn't find a user with id : " + id);
      return null;
    } else {
      return user;
    }
  }

  @Override
  public User findUserByEmail(String email) {
    User user = userDAO.findByEmail(email);
    if (user == null) {
      LOGGER.error("Couldn't find a user with email : " + email);
      return null;
    } else {
      return userDAO.findByEmail(email);
    }
  }
}
