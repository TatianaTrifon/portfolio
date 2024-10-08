package com.fbs.backend.dao;

import com.fbs.backend.JdbcConnection;
import com.fbs.backend.domain.Airport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class AirportDAOImpl implements AirportDAO {

  private static final Logger LOGGER = LoggerFactory.getLogger(AirportDAOImpl.class);

  @Override
  public Airport create(Airport airport) {
    String sql = "INSERT INTO airports(airport_name,country,city) VALUES(?,?,?)";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement createAirport =
            conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      createAirport.setString(1, airport.getName());
      createAirport.setString(2, airport.getCountry());
      createAirport.setString(3, airport.getCity());

      int insertedRows = createAirport.executeUpdate();

      if (insertedRows > 0) {
        ResultSet generatedKeys = createAirport.getGeneratedKeys();

        if (generatedKeys.next()) {
          int generatedId = generatedKeys.getInt(1);
          airport.setId(generatedId);
        }
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to create an airport" + e);
    }

    return airport;
  }

  @Override
  public Airport update(Airport airport) {
    String sql = "UPDATE airports SET airport_name = ? WHERE airport_id = ?";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement updateAirport = conn.prepareStatement(sql)) {

      updateAirport.setString(1, airport.getName());
      updateAirport.setInt(2, airport.getId());

      updateAirport.executeUpdate();

    } catch (SQLException e) {
      LOGGER.error("Failed to update airport with id:  " + airport.getId() + e);
    }

    return airport;
  }

  @Override
  public boolean deleteById(Integer id) {
    String sql = "DELETE FROM airports WHERE airport_id = ?";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement deleteAirport = conn.prepareStatement(sql)) {

      deleteAirport.setInt(1, id);

      deleteAirport.executeUpdate();

    } catch (SQLException e) {
      LOGGER.error("Failed to delete the airport with id: " + id + e);
    }

    return true;
  }

  @Override
  public Airport findById(Integer id) {
    String sql = "SELECT * FROM airports WHERE airport_id = ?";
    Airport airport = new Airport();

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement findAirport = conn.prepareStatement(sql)) {

      if (id != null) {
        findAirport.setInt(1, id);
      } else {
        return null;
      }

      ResultSet resultSet = findAirport.executeQuery();

      while (resultSet.next()) {
        Integer airportId = resultSet.getInt("airport_id");
        String name = resultSet.getString("airport_name");
        String country = resultSet.getString("country");
        String city = resultSet.getString("city");

        airport = new Airport(airportId, name, country, city);
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to find an airport with id: " + id + e);
    }

    return airport;
  }

  @Override
  public Airport findByName(String name) {
    String sql = "SELECT * FROM airports WHERE airport_name = ?";
    Airport airport = new Airport();

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement findAirport = conn.prepareStatement(sql)) {

      findAirport.setString(1, name);

      ResultSet resultSet = findAirport.executeQuery();

      while (resultSet.next()) {
        Integer id = resultSet.getInt("airport_id");
        String airportName = resultSet.getString("airport_name");
        String country = resultSet.getString("country");
        String city = resultSet.getString("city");

        airport = new Airport(id, airportName, country, city);
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to find an airport with the name: " + name + e);
    }

    return airport;
  }
}
