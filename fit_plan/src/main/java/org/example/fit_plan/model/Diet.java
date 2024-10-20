package org.example.fit_plan.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Diet {

    private int dietId;

    private String dietName;

    private String dietDescription;

    private String dietCategory;

    private String allowedFood;

    private String forbiddenFood;

    public Diet(String dietName, String dietDescription, String dietCategory, String allowedFood, String forbiddenFood) {
        this.dietName = dietName;
        this.dietDescription = dietDescription;
        this.dietCategory = dietCategory;
        this.allowedFood = allowedFood;
        this.forbiddenFood = forbiddenFood;
    }
}
