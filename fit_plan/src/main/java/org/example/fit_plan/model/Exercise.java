package org.example.fit_plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    private int exerciseId;

    private String exerciseName;

    private String exerciseDescription;

    private String muscleCategory;

    private byte[] video;

    private String sets;

    public Exercise(String exerciseName, String exerciseDescription, String muscleCategory, byte[] video, String sets) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.muscleCategory = muscleCategory;
        this.video = video;
        this.sets = sets;
    }
}
