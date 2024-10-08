package com.fbs.backend.dao;

import com.fbs.backend.JdbcConnection;
import com.fbs.backend.domain.Airline;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AirlineDAOImpl implements AirlineDAO {

  private static final Logger LOGGER = LoggerFactory.getLogger(AirlineDAOImpl.class);



  @Override
  public Airline create(Airline airline) {
    String sql = "INSERT INTO airlines(airline_name) VALUES (?) ";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement createAirline =
            conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      createAirline.setString(1, airline.getName());

      int insertedRows = createAirline.executeUpdate();

      if (insertedRows > 0) {
        ResultSet generatedKeys = createAirline.getGeneratedKeys();
        if (generatedKeys.next()) {
          int generatedId = generatedKeys.getInt(1);
          airline.setId(generatedId);
        }
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to create an airline" + e);
    }

    return airline;
  }

  @Override
  public Airline update(Airline airline) {
    String sql = "UPDATE airlines SET airline_name = ? WHERE airline_id = ?";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement updateAirline = conn.prepareStatement(sql)) {

      updateAirline.setString(1, airline.getName());
      updateAirline.setInt(2, airline.getId());

      updateAirline.executeUpdate();

    } catch (SQLException e) {
      LOGGER.error("Failed to update the airline with id: " + airline.getId() + e);
    }

    return airline;
  }

  @Override
  public boolean deleteById(Integer id) {
    String sql = "DELETE FROM airlines WHERE airline_id = ?";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement deleteAirline = conn.prepareStatement(sql)) {

      deleteAirline.setInt(1, id);

      deleteAirline.executeUpdate();

    } catch (SQLException e) {
      LOGGER.error("Failed to delete the airline with id: " + id + e);
    }

    return true;
  }

  @Override
  public Airline findById(Integer id) {
    String sql = "SELECT * FROM airlines WHERE airline_id = ?";
    Airline airline = new Airline();

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement findAirline = conn.prepareStatement(sql)) {

      if (id != null) {
        findAirline.setInt(1, id);
      } else {
        return null;
      }

      ResultSet resultSet = findAirline.executeQuery();

      while (resultSet.next()) {
        Integer airlineId = resultSet.getInt("airline_id");
        String name = resultSet.getString("airline_name");

        airline = new Airline(airlineId, name);
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to find an airline with id: " + id + e);
    }

    return airline;
  }

  @Override
  public Airline findByName(String name) {
    String sql = "SELECT * FROM airlines WHERE airline_name = ?";
    Airline airline = new Airline();

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement findAirline = conn.prepareStatement(sql)) {

      findAirline.setString(1, name);

      ResultSet resultSet = findAirline.executeQuery();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("airline_id");
        String airlineName = resultSet.getString("airline_name");

        airline = new Airline(id, airlineName);
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to find an airport with name: " + name + e);
    }

    return airline;
  }
}
