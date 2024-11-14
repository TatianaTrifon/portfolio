package org.example.fit_plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.InputStream;


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

    private String gender;

    public Exercise(String exerciseName, String exerciseDescription, String muscleCategory, byte[] video, String sets, String gender) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.muscleCategory = muscleCategory;
        this.video = video;
        this.sets = sets;
        this.gender = gender;
    }

    public Exercise(String exerciseName, String exerciseDescription, String muscleCategory, byte[] video, String sets) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.muscleCategory = muscleCategory;
        this.video = video;
        this.sets = sets;
    }

    public Exercise(int exerciseId, String exerciseName, String exerciseDescription, String muscleCategory, String sets, String gender) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.muscleCategory = muscleCategory;
        this.sets = sets;
        this.gender = gender;
    }

    public Exercise(int exerciseId, String exerciseName, String exerciseDescription, String muscleCategory, byte[] video, String sets) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.muscleCategory = muscleCategory;
        this.video = video;
        this.sets = sets;
    }
}
