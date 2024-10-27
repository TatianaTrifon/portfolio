package org.example.fit_plan.dao.implimentations;

import org.example.fit_plan.JdbcConnection;
import org.example.fit_plan.dao.UserDAO;
import org.example.fit_plan.model.User;
import org.example.fit_plan.model.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    JdbcConnection jdbcConnection = new JdbcConnection();

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public User create(User user) {
        String sql = "INSERT INTO user(user_email,username,user_password) VALUES(?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createUser = conn.prepareStatement(sql)) {

            createUser.setString(1, user.getEmail());
            createUser.setString(2, user.getUsername());
            createUser.setString(3, user.getPassword());

            createUser.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to create an user! " + e);
        }

        return user;

    }

    @Override
    public User update(User user) {

        String sql = "UPDATE user SET user_email = ?, user_password = ? WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateUser = conn.prepareStatement(sql)) {

            updateUser.setString(1, user.getEmail());
            updateUser.setString(2, user.getUsername());
            updateUser.setInt(3, user.getUserId());

            updateUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to update the user with id! " + user.getUserId() + e);
        }

        return user;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM user WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUser = conn.prepareStatement(sql)) {

            deleteUser.setInt(1, id);
            deleteUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to delete user with id: " + id + e);
        }

        return true;
    }

    @Override
    public User findById(Integer id) {
        User user = new User();

        String sql = "SELECT * FROM user WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findUser = conn.prepareStatement(sql)) {

            findUser.setInt(1, id);

            ResultSet resultSet = findUser.executeQuery();

            while(resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String email = resultSet.getString("user_email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("user_password");

                user = new User(userId, email, username, password);

            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any user with id: " + id + e);
        }

        return user;
    }

    @Override
    public User findByName(String name) {
        User user = new User();

        String sql = "SELECT * FROM user WHERE username = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement findUser = conn.prepareStatement(sql)) {

            findUser.setString(1, name);

            ResultSet resultSet = findUser.executeQuery();

            while(resultSet.next()) {

                int userId = resultSet.getInt("user_id");
                String email = resultSet.getString("user_email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("user_password");

                user = new User(userId, email, username, password);
            }

        } catch (SQLException e) {
            LOGGER.error("Failed to find any user with the name: " + name + e);
        }

        return user;
    }
}
