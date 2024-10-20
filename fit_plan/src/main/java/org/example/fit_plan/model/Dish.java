package org.example.fit_plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private int dishId;

    private String dishName;

    private double calories;

    private String nutrients;

    public Dish(String dishName, double calories, String nutrients) {
        this.dishName = dishName;
        this.calories = calories;
        this.nutrients = nutrients;
    }
}
