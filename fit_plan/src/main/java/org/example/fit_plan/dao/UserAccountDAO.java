package org.example.fit_plan.dao;


import org.example.fit_plan.model.UserAccount;

public interface UserAccountDAO extends DAO<UserAccount> {

    UserAccount create(UserAccount user);

    UserAccount update(UserAccount user);

    boolean addDietToUserById(Integer dietId, Integer userId);

    boolean deleteById(Integer id);

    boolean deleteDietById(Integer id);

    boolean deleteExerciseById(Integer exerciseId);

    boolean deleteDishById(Integer dishId);

    UserAccount findById(Integer id);



}
