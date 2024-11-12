package org.example.fit_plan.dao;

import org.example.fit_plan.model.Weight;

import java.util.List;

public interface WeightDAO  {

    Weight create (Weight weight);

    List<Weight> findById(Integer id);
}
