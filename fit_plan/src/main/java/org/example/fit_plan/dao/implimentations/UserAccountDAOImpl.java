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

public class UserAccountDAOImpl implements UserAccountDAO {

    JdbcConnection jdbcConnection = new JdbcConnection();

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountDAOImpl.class);

    @Override
    public UserAccount create(UserAccount user) {

        String sql = "INSERT INTO user_account(user_id,gender,height,weight,diet_id) VALUES(?,?,?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createUserAccount = conn.prepareStatement(sql)) {

            createUserAccount.setInt(1, user.getUserId());
            createUserAccount.setString(2, user.getGender());
            createUserAccount.setDouble(3, user.getHeight());
            createUserAccount.setDouble(4, user.getWeight());
            createUserAccount.setInt(5, user.getDietId());

            createUserAccount.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create an userAccount! " + e);
        }

        return user;
    }

    @Override
    public UserAccount update(UserAccount user) {

        String sql = "UPDATE user_account SET height = ?, weight = ? WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateUser = conn.prepareStatement(sql)) {

            updateUser.setDouble(1, user.getHeight());
            updateUser.setDouble(2, user.getWeight());
            updateUser.setInt(3, user.getUserId());

            updateUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to update the user account with id! " + user.getUserId() + e);
        }

        return user;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM user_account WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUser = conn.prepareStatement(sql)) {

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
    public UserAccount findById(Integer id) {

        UserAccount userAccount = new UserAccount();

        String sql = "SELECT * FROM user_account WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findUser = conn.prepareStatement(sql)) {

            findUser.setInt(1, id);

            ResultSet resultSet = findUser.executeQuery();

            int userId = resultSet.getInt("user_id");
            String gender = resultSet.getString("gender");
            double height = resultSet.getDouble("height");
            double weight = resultSet.getDouble("weight");
            int dietId = resultSet.getInt("diet_id");

            userAccount = new UserAccount(userId, gender, height, weight, dietId);

        } catch (SQLException e) {
            LOGGER.error("Failed to find any user account with id: " + id + e);
        }

        return userAccount;
    }
}
