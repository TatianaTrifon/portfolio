package org.example.fit_plan.dao;

import org.example.fit_plan.model.Dish;

import java.util.List;

public interface DishDAO extends DAO<Dish> {

    Dish create(Dish dish);

    Dish update(Dish dish);

    boolean deleteById(Integer id);

    Dish findById(Integer id);

    List<Dish> findByIngredient(String ingredient);

    List<Dish> findByName(String name);

    List<Dish> findAll();

}
