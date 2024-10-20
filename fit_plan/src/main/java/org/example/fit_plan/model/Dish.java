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

    private String ingredients;

    private String instructions;

    private double calories;

    private String nutrients;

    public Dish(String dishName, String ingredients, String instructions, double calories, String nutrients) {
        this.dishName = dishName;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.calories = calories;
        this.nutrients = nutrients;
    }
}
