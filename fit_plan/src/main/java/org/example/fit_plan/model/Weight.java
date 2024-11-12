package org.example.fit_plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weight {

   private Integer userId;

   private Double weight;

   private Timestamp entryDate;


    public Weight(Double weight, Timestamp entryDate) {
        this.weight = weight;
        this.entryDate = entryDate;
    }
}
