package com.fbs.backend.dao;

import com.fbs.backend.JdbcConnection;
import com.fbs.backend.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDAOImpl implements UserDAO {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);


  @Override
  public User create(User user) {
    String sql =
        "INSERT INTO users(first_name,last_name,email,role,phone_number) VALUES (?,?,?,?,?);";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement createUser =
            conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      createUser.setString(1, user.getFirstName());
      createUser.setString(2, user.getLastName());
      createUser.setString(3, user.getEmail());
      createUser.setString(4, user.getRole());
      createUser.setString(5, user.getPhoneNumber());

      int rowsInserted = createUser.executeUpdate();

      if (rowsInserted > 0) {
        ResultSet generatedKeys = createUser.getGeneratedKeys();
        if (generatedKeys.next()) {
          int generatedId = generatedKeys.getInt(1);
          user.setId(generatedId);
        }
      }
    } catch (SQLException e) {
      LOGGER.error("Failed to create user");
    }
    return user;
  }

  @Override
  public User update(User user) {
    String sql = "UPDATE users SET email = ? WHERE users.users_id = ?;";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement updateUser = conn.prepareStatement(sql)) {

      updateUser.setString(1, user.getEmail());
      updateUser.setInt(2, user.getId());

      updateUser.executeUpdate();
    } catch (SQLException e) {
      LOGGER.error("Failed to update user with id: " + user.getId());
    }

    return user;
  }


  @Override
  public boolean deleteById(Integer id) {

    String sql = "DELETE FROM users WHERE users_id = ?";
    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement deleteUserById = conn.prepareStatement(sql)) {

      if (id != null){
      deleteUserById.setInt(1, id);}
      else{
        return false;
      }

      deleteUserById.executeUpdate();
    } catch (SQLException e) {
      LOGGER.error("Failed to delete the user with id:" + id);
    }
    return true;
  }

  @Override
  public User findById(Integer id) {
    String sql = "SELECT * FROM users WHERE users.users_id = ?";

    User user = new User();
    try (Connection conn = JdbcConnection.getConnection(); // not working
        PreparedStatement findUserById = conn.prepareStatement(sql)) {

if (id != null){
      findUserById.setInt(1, id);}
else{
  return null;
}

      ResultSet resultSet = findUserById.executeQuery();

      while (resultSet.next()) {
        Integer userId = resultSet.getInt("users_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        String role = resultSet.getString("role");
        String phoneNumber = resultSet.getString("phone_number");


        user = new User(userId, firstName, lastName, email, role, phoneNumber);
      }

    } catch (SQLException e) {

      LOGGER.error("Failed to find a user with id: " + id);
    }
    return user;
  }

  @Override
  public User findByEmail(String email) {
    String sql = "SELECT * FROM users WHERE users.email =?";
    User user = new User();

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement findByEmail = conn.prepareStatement(sql)) {

      findByEmail.setString(1, email);

      ResultSet resultSet = findByEmail.executeQuery();

      while (resultSet.next()) {
        int userId = resultSet.getInt("users_id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String userEmail = resultSet.getString("email");
        String role = resultSet.getString("role");
        String phoneNumber = resultSet.getString("phone_number");


        user = new User(userId, firstName, lastName, userEmail, role, phoneNumber);
      }
    } catch (SQLException e) {
      LOGGER.error("Failed to find a user with email:  " + user.getEmail());
    }
    return user;
  }
}
