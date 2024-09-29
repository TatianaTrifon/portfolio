package org.example.task_manager.dao;

import org.example.task_manager.entities.User;

public interface UserDAO extends DAO<User> {

    User create(User user);

    User update(User user);

    boolean deleteById(Integer id);

    User findByLogin(String login);
}
