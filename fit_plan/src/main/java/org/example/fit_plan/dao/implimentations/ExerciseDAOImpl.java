package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.ExerciseDAO;

import org.example.fit_plan.model.Exercise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDAOImpl implements ExerciseDAO {

    JdbcConnection jdbcConnection = new JdbcConnection();

    private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseDAOImpl.class);


    @Override
    public Exercise create(Exercise exercise) {

        String sql = "INSERT INTO exercise(exercise_name,exercise_description,muscle_category,media,sets, gender) VALUES (?,?,?,?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createExercise = conn.prepareCall(sql)) {

            createExercise.setString(1, exercise.getExerciseName());
            createExercise.setString(2, exercise.getExerciseDescription());
            createExercise.setString(3, exercise.getMuscleCategory());
            createExercise.setBytes(4, exercise.getVideo());
            createExercise.setString(5, exercise.getSets());
            createExercise.setString(6, exercise.getGender());

            createExercise.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create an exercise! " + e);
        }


        return exercise;
    }

    @Override
    public Exercise update(Exercise exercise) {

        String sql = "UPDATE exercise SET exercise_name = ?, exercise_description = ?, muscle_category = ?, sets =?, gender = ? WHERE exercise_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateExercise = conn.prepareCall(sql)) {

            updateExercise.setString(1, exercise.getExerciseName());
            updateExercise.setString(2, exercise.getExerciseDescription());
            updateExercise.setString(3, exercise.getMuscleCategory());
            updateExercise.setString(4, exercise.getSets());
            updateExercise.setString(5, exercise.getGender());
            updateExercise.setInt(6, exercise.getExerciseId());

            updateExercise.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update the exercise with id: " + exercise.getExerciseId() + e);
        }

        return exercise;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM exercise WHERE exercise_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteExercise = conn.prepareCall(sql)) {

            deleteExercise.setInt(1, id);

            deleteExercise.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete the exercise with id: " + id + e);
        }

        return true;
    }

    @Override
    public Exercise findById(Integer id) {

        Exercise exercise = new Exercise();

        String sql = "SELECT * FROM exercise WHERE exercise_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findExercise = conn.prepareCall(sql)) {

            findExercise.setInt(1, id);

            ResultSet resultSet = findExercise.executeQuery();

            while(resultSet.next()) {
                int exerciseId = resultSet.getInt("exercise_id");
                String name = resultSet.getString("exercise_name");
                String description = resultSet.getString("exercise_description");
                String muscleCategory = resultSet.getString("muscle_category");
                byte[] media = resultSet.getBytes("media");
                String sets = resultSet.getString("sets");
                String gender = resultSet.getString("gender");

                exercise = new Exercise(exerciseId, name, description, muscleCategory, media, sets, gender);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find an exercise with id: " + id + e);
        }


        return exercise;
    }

    public List<Exercise> findByCategoryAndGender(String category, String gender) {
        List<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM exercise WHERE muscle_category = ? AND gender = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findExercise = conn.prepareStatement(sql)) {

            findExercise.setString(1, category);
            findExercise.setString(2, gender);

            ResultSet resultSet = findExercise.executeQuery();

            while(resultSet.next()) {
                int exerciseId = resultSet.getInt("exercise_id");
                String name = resultSet.getString("exercise_name");
                String description = resultSet.getString("exercise_description");
                String muscleCategory = resultSet.getString("muscle_category");
                byte[] media = resultSet.getBytes("media");
                String sets = resultSet.getString("sets");
                String genderValue = resultSet.getString("gender");

                exercises.add(new Exercise(exerciseId, name, description, muscleCategory, media, sets, genderValue));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find any exercise by category and gender: " + e.getMessage());
        }

        return exercises;
    }


    @Override
    public List<Exercise> findAll() {
        List<Exercise> exercises = new ArrayList<>();

        String sql = "SELECT * FROM exercise";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findExercise = conn.prepareCall(sql)) {


            ResultSet resultSet = findExercise.executeQuery();

            while(resultSet.next()) {
                int exerciseId = resultSet.getInt("exercise_id");
                String name = resultSet.getString("exercise_name");
                String description = resultSet.getString("exercise_description");
                String muscleCategory = resultSet.getString("muscle_category");
                byte[] media = resultSet.getBytes("media");
                String sets = resultSet.getString("sets");
                String gender = resultSet.getString("gender");

                exercises.add(new Exercise(exerciseId, name, description, muscleCategory, media, sets, gender));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find any exercise" + e);
        }


        return exercises;
    }

    @Override
    public boolean addToProgress(Integer userId, Integer exerciseId) {

        String sql = "INSERT INTO user_account_exercises (user_id,exercise_id) VALUES (?,?)";


        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement addExercise = conn.prepareStatement(sql)){

            addExercise.setInt(1, userId);
            addExercise.setInt(2, exerciseId);
            addExercise.executeUpdate();


        }catch (SQLException e){
            LOGGER.error("Failed to add the exercise to progress");
        }

        return true;
    }

    @Override
    public List<Exercise> findExerciseByUserAccountId(Integer id) {

        List<Exercise> exercises = new ArrayList<>();

        String sql = "SELECT exercise.exercise_name, exercise.exercise_description, exercise.muscle_category, exercise.media, exercise.sets FROM exercise JOIN user_account_exercises ON exercise.exercise_id = user_account_exercises.exercise_id WHERE user_account_exercises.user_id = ? ";

        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement findExercises = conn.prepareStatement(sql)){

            findExercises.setInt(1, id);

            ResultSet resultSet = findExercises.executeQuery();

            while(resultSet.next()){

                String name = resultSet.getString("exercise_name");
                String description = resultSet.getString("exercise_description");
                String muscleCategory = resultSet.getString("muscle_category");
                byte[] media = resultSet.getBytes("media");
                String sets = resultSet.getString("sets");

                exercises.add(new Exercise(name,description,muscleCategory,media,sets));
            }


        }catch (SQLException e){
            LOGGER.error("Failed to find any exercises! " + e);
        }


        return exercises;
    }
}
