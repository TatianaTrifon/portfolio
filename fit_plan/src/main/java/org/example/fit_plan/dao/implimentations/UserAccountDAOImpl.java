package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.UserAccountDAO;
import org.example.fit_plan.model.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class UserAccountDAOImpl implements UserAccountDAO {

    JdbcConnection jdbcConnection = new JdbcConnection();

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountDAOImpl.class);

    @Override
    public UserAccount create(UserAccount user) {

        String sql = "INSERT INTO user_account(user_id, age,gender,height,weight,activity) VALUES(?,?,?,?,?,?)";
        String weightSql = "INSERT INTO weight_history(user_id, weight) VALUES (?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createUserAccount = conn.prepareStatement(sql);
             PreparedStatement addWeightHistory = conn.prepareStatement(weightSql)) {

            createUserAccount.setInt(1, user.getUserId());
            createUserAccount.setInt(2, user.getAge());
            createUserAccount.setString(3, user.getGender());
            createUserAccount.setDouble(4, user.getHeight());
            createUserAccount.setDouble(5, user.getWeight());
            createUserAccount.setString(6, user.getActivity());

            addWeightHistory.setInt(1, user.getUserId());
            addWeightHistory.setDouble(2, user.getWeight());


            createUserAccount.executeUpdate();
            addWeightHistory.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create an userAccount! " + e);
        }

        return user;
    }

    @Override
    public UserAccount update(UserAccount user) {

        String sql = "UPDATE user_account SET height = ?, weight = ?, activity = ? WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateUser = conn.prepareStatement(sql)) {

            updateUser.setDouble(1, user.getHeight());
            updateUser.setDouble(2, user.getWeight());
            updateUser.setString(3, user.getActivity());
            updateUser.setInt(4, user.getUserId());

            updateUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to update the user account with id! " + user.getUserId() + e);
        }

        return user;
    }

    @Override
    public boolean addDietToUserById(Integer dietId, Integer userId) {

        String sql = "UPDATE user_account SET diet_id = ? WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement addDiet = conn.prepareStatement(sql)) {

            addDiet.setInt(1, dietId);
            addDiet.setInt(2, userId);
            addDiet.executeUpdate();

        } catch (SQLException e) {
            java.util.logging.Logger.getLogger(UserAccountDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        }


        return true;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM user_account WHERE user_id = ?";
        String userAccountDish = "DELETE FROM user_account_dishes WHERE user_id = ?";
        String userAccountExercise = "DELETE FROM user_account_exercises WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUser = conn.prepareStatement(sql);
             PreparedStatement deleteUserDish = conn.prepareStatement(userAccountDish);
             PreparedStatement deleteUserExercise = conn.prepareStatement(userAccountExercise)) {

            deleteUserDish.setInt(1, id);
            deleteUserDish.executeUpdate();

            deleteUserExercise.setInt(1, id);
            deleteUserExercise.executeUpdate();

            deleteUser.setInt(1, id);
            deleteUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to delete user account with id: " + id + e);
        }

        return true;
    }

    @Override
    public boolean deleteDietById(Integer id) {

        String sql = "UPDATE user_account SET diet_id = NULL WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUser = conn.prepareStatement(sql)) {

            deleteUser.setInt(1, id);
            deleteUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to delete diet from account with id: " + id + e);
        }

        return true;
    }

    @Override
    public boolean deleteExerciseById(Integer exerciseId) {
        String userAccountExercise = "DELETE FROM user_account_exercises WHERE exercise_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUserExercise = conn.prepareStatement(userAccountExercise)) {


            deleteUserExercise.setInt(1, exerciseId);
            deleteUserExercise.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to delete user account with id: " + exerciseId + e);
        }

        return true;
    }

    @Override
    public boolean deleteDishById(Integer dish_id) {
        String userAccountDish = "DELETE FROM user_account_dishes WHERE dish_id = ?;";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUserDish = conn.prepareStatement(userAccountDish)) {

            deleteUserDish.setInt(1, dish_id);
            deleteUserDish.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to delete user account with id: " + dish_id + e);
        }

        return true;
    }

    @Override
    public UserAccount findById(Integer id) {

        UserAccount userAccount = new UserAccount();

        String sql = "SELECT * FROM user_account WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findUser = conn.prepareStatement(sql)) {

            findUser.setInt(1, id);

            ResultSet resultSet = findUser.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                double height = resultSet.getDouble("height");
                double weight = resultSet.getDouble("weight");
                String activity = resultSet.getString("activity");
                int dietId = resultSet.getInt("diet_id");

                userAccount = new UserAccount(userId, age, gender, height, weight, activity, dietId);
            }
        } catch (SQLException e) {
            LOGGER.error("Failed to find any user account with id: " + id + e);
        }

        return userAccount;
    }
}
