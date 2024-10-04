package org.example.task_manager.dao.implementations;

import org.example.task_manager.JdbcConnection;
import org.example.task_manager.dao.UserDAO;
import org.example.task_manager.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    JdbcConnection jdbcConnection = new JdbcConnection();

    @Override
    public User create(User user) {

        String sql = "INSERT INTO user(username,username_password,user_email) VALUES(?,?,?)";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement createUser = conn.prepareCall(sql)) {

            createUser.setString(1, user.getUsername());
            createUser.setString(2, user.getPassword());
            createUser.setString(3, user.getEmail());

            createUser.executeUpdate();


        } catch (SQLException e) {
            LOGGER.error("Failed to create an user " + e);
        }


        return user;
    }

    @Override
    public User update(User user) {

        String sql = "UPDATE user SET username_password = ? WHERE user_id = ?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement updateUser = conn.prepareCall(sql)) {

            updateUser.setString(1, user.getPassword());
            updateUser.setInt(2, user.getId());

            updateUser.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to update the user with id: " + user.getId() + e);
        }

        return user;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql = "DELETE FROM user WHERE user_id = ?";
        String deleteTask = "DELETE FROM task WHERE user_id =?";

        try (Connection conn = jdbcConnection.getConnection();
             PreparedStatement deleteUser = conn.prepareCall(sql);
             PreparedStatement deleteUserTask = conn.prepareCall(deleteTask)) {

            deleteUserTask.setInt(1,id);
            deleteUser.setInt(1, id);

            deleteUserTask.executeUpdate();
            deleteUser.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error("Failed to delete the user with id: " + id + e);
        }


        return true;
    }

    @Override
    public User findByLogin(String login) {

        User user = new User();

        String sql = "SELECT * FROM user WHERE username = ?";

        try(Connection conn = jdbcConnection.getConnection();
        PreparedStatement findUser = conn.prepareCall(sql)){

            findUser.setString(1, login);

            ResultSet resultSet = findUser.executeQuery();

            while(resultSet.next()){

                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String userPassword = resultSet.getString("username_password");
                String email = resultSet.getString("user_email");

                user = new User(id,username,userPassword,email);
            }

        } catch(SQLException e){
            LOGGER.error("Failed to find a user with login: " + login + e);
        }

        return user;
    }
}
