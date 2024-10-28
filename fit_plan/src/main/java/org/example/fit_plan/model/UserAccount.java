package org.example.fit_plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {

    private int userId;

    private String gender;

    private double height;

    private double weight;

    private String activity;

    private int dietId;

    public UserAccount(int userId, String gender, double height, double weight, String activity) {
        this.userId = userId;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
    }
}

