package org.example.fit_plan.dao;

import org.example.fit_plan.model.User;



public interface UserDAO extends DAO<User>{

    User create(User user);

    User update(User user);

    boolean deleteById(Integer id);

    User findById(Integer id);


}