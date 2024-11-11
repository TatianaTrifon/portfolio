package org.example.fit_plan.dao;

import org.example.fit_plan.model.Diet;


import java.util.List;

public interface DietDAO extends DAO<Diet> {

    Diet create(Diet diet);

    Diet update(Diet diet);

    boolean deleteById(Integer id);

    Diet findById(Integer id);

    List<Diet> findDietsByCategory(String category);

    List<Diet> findRecommendedDiets();

    List<Diet> findAllDiets();

}
