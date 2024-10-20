package org.example.fit_plan.dao;


import org.example.fit_plan.model.UserAccount;

public interface UserAccountDAO extends DAO<UserAccount> {

    UserAccount create(UserAccount user);

    UserAccount update(UserAccount user);

    boolean deleteById(Integer id);

    UserAccount findById(Integer id);



}
