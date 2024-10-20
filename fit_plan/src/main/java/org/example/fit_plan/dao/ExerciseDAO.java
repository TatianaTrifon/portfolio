package org.example.fit_plan.dao;

import org.example.fit_plan.model.Exercise;

import java.util.List;

public interface ExerciseDAO extends DAO<Exercise> {

    Exercise create(Exercise exercise);

    Exercise update(Exercise exercise);

    boolean deleteById(Integer id);

    List<Exercise>  findByCategory(String category);

    List<Exercise> findAll();


}
