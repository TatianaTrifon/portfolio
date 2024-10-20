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

    private int dietId;



}

