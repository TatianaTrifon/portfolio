package com.fbs.backend.dao;

import com.fbs.backend.JdbcConnection;
import com.fbs.backend.domain.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class FlightDAOImpl implements FlightDAO {

  private static final Logger LOGGER = LoggerFactory.getLogger(FlightDAOImpl.class);

  @Override
  public Flight create(Flight flight) {
    String sql =
        "INSERT INTO flight(airline_id, seat_class, departure_airport_id, destination_airport_id, time_start, time_end) VALUES(?,?,?,?,?,?)";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement createFlight =
            conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

      createFlight.setInt(1, flight.getAirlineId());
      createFlight.setString(2, flight.getSeatClass());
      createFlight.setInt(3, flight.getDepartureAirportId());
      createFlight.setInt(4, flight.getDestinationAirportId());
      createFlight.setTimestamp(5, new java.sql.Timestamp(flight.getTimeStart().getTime()));
      createFlight.setTimestamp(6, new java.sql.Timestamp(flight.getTimeEnd().getTime()));

      int insertedRows = createFlight.executeUpdate();

      if (insertedRows > 0) {
        ResultSet generatedKeys = createFlight.getGeneratedKeys();

        if (generatedKeys.next()) {
          int generatedId = generatedKeys.getInt(1);
          flight.setId(generatedId);

          String usersTicketSql = "INSERT INTO users_flight(users_id, flight_id) VALUES (?,?)";

          try (PreparedStatement createUserTicket = conn.prepareStatement(usersTicketSql)) {
            createUserTicket.setInt(1, flight.getUserId());
            createUserTicket.setInt(2, generatedId);
            createUserTicket.executeUpdate();
          }
        }
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to create a flight " + e);
    }

    return flight;
  }

  @Override
  public Flight update(Flight flight) {
    String sql = "UPDATE flight SET time_start = ?, time_end = ? WHERE flight_id = ?";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement updateFlight = conn.prepareStatement(sql)) {

      updateFlight.setTimestamp(1, new java.sql.Timestamp(flight.getTimeStart().getTime()));
      updateFlight.setTimestamp(2, new java.sql.Timestamp(flight.getTimeEnd().getTime()));
      updateFlight.setInt(3, flight.getId());

      updateFlight.executeUpdate();

    } catch (SQLException e) {
      LOGGER.error("Failed to update the flight with id: " + flight.getId() + e);
    }

    return flight;
  }

  @Override
  public boolean deleteById(Integer id) {
    String sql = "DELETE FROM flight WHERE flight.flight_id = ?";
    String usersFlightSql = "DELETE FROM users_flight WHERE users_flight.flight_id = ?";

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement deleteUsersFlight = conn.prepareStatement(usersFlightSql);
        PreparedStatement deleteFlight = conn.prepareStatement(sql)) {

      deleteUsersFlight.setInt(1, id);
      deleteFlight.setInt(1, id);

      deleteUsersFlight.executeUpdate();
      deleteFlight.executeUpdate();


    } catch (SQLException e) {
      LOGGER.error("Failed to delete the flight with id :  " + id + e);
    }

    return true;
  }

  @Override
  public Flight findById(Integer id) {
    String sql =
        "SELECT flight.flight_id,"
            + " flight.airline_id,"
            + " flight.seat_class,"
            + " flight.departure_airport_id,"
            + " flight.destination_airport_id,"
            + " flight.time_start,"
            + " flight.time_end,"
            + " users.users_id,"
            + " users.first_name,"
            + " users.last_name"
            + " FROM flight"
            + " JOIN users_flight"
            + " ON users_flight.flight_id = flight.flight_id "
            + "JOIN users"
            + " ON users_flight.users_id = users.users_id "
            + "WHERE flight.flight_id = ?";

    Flight flight = new Flight();

    try (Connection conn = JdbcConnection.getConnection();
        PreparedStatement findFlight = conn.prepareStatement(sql)) {

      if (id != null) {
        findFlight.setInt(1, id);
      } else {
        return null;
      }

      ResultSet resultSet = findFlight.executeQuery();

      while (resultSet.next()) {
        Integer flightId = resultSet.getInt("flight_id");
        Integer airlineId = resultSet.getInt("airline_id");
        String seatClass = resultSet.getString("seat_class");
        Integer departureId = resultSet.getInt("departure_airport_id");
        Integer destinationId = resultSet.getInt("destination_airport_id");
        Timestamp timeStart = resultSet.getTimestamp("time_start");
        Timestamp timeEnd = resultSet.getTimestamp("time_end");
        Integer userId = resultSet.getInt("users_id");
        String userFirstName = resultSet.getString("first_name");
        String userLastName = resultSet.getString("last_name");

        flight =
            new Flight(
                flightId,
                airlineId,
                seatClass,
                departureId,
                destinationId,
                timeStart,
                timeEnd,
                userId,
                userFirstName,
                userLastName);
      }

    } catch (SQLException e) {
      LOGGER.error("Failed to find a flight with id: " + id + e);
    }

    return flight;
  }
}
