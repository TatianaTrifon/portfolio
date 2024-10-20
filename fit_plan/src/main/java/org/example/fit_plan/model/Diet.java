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

    private String description;

    private String allowedFood;

    private String forbiddenFood;

    public Diet(String dietName, String description, String allowedFood, String forbiddenFood) {
        this.dietName = dietName;
        this.description = description;
        this.allowedFood = allowedFood;
        this.forbiddenFood = forbiddenFood;
    }

}
