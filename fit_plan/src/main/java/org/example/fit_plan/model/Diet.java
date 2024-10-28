package org.example.fit_plan.model;


import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Diet {

    private int dietId;

    private byte[] picture;

    private String dietName;

    private String dietDescription;

    private String dietCategory;

    private String allowedFood;

    private String forbiddenFood;

    public Diet(byte[] picture, String dietName, String dietDescription, String dietCategory, String allowedFood, String forbiddenFood) {
       this.picture = picture;
        this.dietName = dietName;
        this.dietDescription = dietDescription;
        this.dietCategory = dietCategory;
        this.allowedFood = allowedFood;
        this.forbiddenFood = forbiddenFood;
    }
}
