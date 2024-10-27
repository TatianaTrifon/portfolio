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

        String sql = "INSERT INTO exercise(exercise_name,exercise_description,muscle_category,media,sets) VALUES (?,?,?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createExercise = conn.prepareCall(sql)) {

            createExercise.setString(1, exercise.getExerciseName());
            createExercise.setString(2, exercise.getExerciseDescription());
            createExercise.setString(3, exercise.getMuscleCategory());
            createExercise.setBytes(4, exercise.getVideo());
            createExercise.setString(5, exercise.getSets());

            createExercise.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create an exercise! " + e);
        }


        return exercise;
    }

    @Override
    public Exercise update(Exercise exercise) {

        String sql = "UPDATE exercise SET media = ? WHERE exercise_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateExercise = conn.prepareCall(sql)) {

            updateExercise.setBytes(1, exercise.getVideo());
            updateExercise.setInt(2, exercise.getExerciseId());

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

                exercise = new Exercise(exerciseId, name, description, muscleCategory, media, sets);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find an exercise with id: " + id + e);
        }


        return exercise;
    }

    @Override
    public List<Exercise> findByCategory(String category) {

        List<Exercise> exercises = new ArrayList<>();

        String sql = "SELECT * FROM exercise WHERE exercise_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findExercise = conn.prepareCall(sql)) {

            findExercise.setString(1, category);

            ResultSet resultSet = findExercise.executeQuery();

            while(resultSet.next()) {
                int exerciseId = resultSet.getInt("exercise_id");
                String name = resultSet.getString("exercise_name");
                String description = resultSet.getString("exercise_description");
                String muscleCategory = resultSet.getString("muscle_category");
                byte[] media = resultSet.getBytes("media");
                String sets = resultSet.getString("sets");

                exercises.add(new Exercise(exerciseId, name, description, muscleCategory, media, sets));

            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find any exercise" + e);
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

                exercises.add(new Exercise(exerciseId, name, description, muscleCategory, media, sets));
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find any exercise" + e);
        }


        return exercises;
    }
}
