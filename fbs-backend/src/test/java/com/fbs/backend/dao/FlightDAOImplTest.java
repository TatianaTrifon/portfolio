package com.fbs.backend.dao;

import com.fbs.backend.JdbcConnection;
import com.fbs.backend.domain.Flight;
import com.fbs.backend.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static net.minidev.asm.ConvertDate.convertToDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.toDate;

@SpringBootTest
class FlightDAOImplTest {

  @Autowired private FlightDAO flightDAO;
  @Autowired private UserDAO userDAO;

  @AfterEach
  void tearDown() {
    String sql = "DELETE FROM users_flight";
    String usersql = "DELETE FROM users";
    String flightSql = "DELETE FROM flight";
    try (Connection connection = JdbcConnection.getConnection()) {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.executeUpdate();

      PreparedStatement userStatement = connection.prepareStatement(usersql);
      userStatement.executeUpdate();

      PreparedStatement flightStatement = connection.prepareStatement(flightSql);
      flightStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private Timestamp getTimeStart() throws ParseException {
    String dateString = "2023-10-20 3:00";
    java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
    return new java.sql.Timestamp(utilDate.getTime());
  }

  private Timestamp getTimeEnd() throws ParseException {
    String dateString = "2023-10-20 6:00";
    java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
    return new java.sql.Timestamp(utilDate.getTime());
  }

  @Test
  void shouldCreateFlight() throws ParseException {
    User user =
        new User("Anton", "Ivanovici", "anton.ivanoovici@gmail.com", "passenger", "634101463");
    assertNotNull(userDAO.create(user));
    Flight flight = new Flight(38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), user.getId());
    assertNotNull(flightDAO.create(flight));

    Flight testFlight = flightDAO.findById(flight.getId());
    assertNotNull(testFlight);
  }

  @Test
  void shouldUpdateFlight() throws ParseException {
    User user =
        new User("Anton", "Ivanovici", "anton.ivanoovici@gmail.com", "passenger", "634101463");
    assertNotNull(userDAO.create(user));
    Flight flight = new Flight(38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), user.getId());
    assertNotNull(flightDAO.create(flight));

    String newTimeStart = "2023-10-20 06:00:00";
    String newTimeEnd = "2023-10-20 09:00:00";

    java.sql.Timestamp newTimestampStart = java.sql.Timestamp.valueOf(newTimeStart);
    java.sql.Timestamp newTimestampEnd = java.sql.Timestamp.valueOf(newTimeEnd);

    flight.setTimeStart(newTimestampStart);
    flight.setTimeEnd(newTimestampEnd);

    Flight updatedFlight = flightDAO.update(flight);
    assertNotNull(updatedFlight);

    Flight testFlight = flightDAO.findById(updatedFlight.getId());
    assertNotNull(testFlight);
    assertEquals(testFlight.getTimeStart(), updatedFlight.getTimeStart());
    assertEquals(testFlight.getTimeEnd(), updatedFlight.getTimeEnd());
  }

  @Test
  void shouldCreateIfNotFound() throws ParseException {
    User user =
        new User("Anton", "Ivanovici", "anton.ivanoovici@gmail.com", "passenger", "634101463");
    assertNotNull(userDAO.create(user));
    Flight flight = new Flight(38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), user.getId());

    assertNull(flightDAO.findById(flight.getId()));

    assertNotNull(flightDAO.create(flight));

    Flight testFlight = flightDAO.findById(flight.getId());
    assertNotNull(testFlight);
    assertEquals(testFlight.getId(), flight.getId());
  }

  @Test
  void shouldDeleteFlightById() throws ParseException {
    User user =
        new User("Anton", "Ivanovici", "anton.ivanovici@gmail.com", "passenger", "634101463");
    assertNotNull(userDAO.create(user));
    Flight flight = new Flight(38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), user.getId());
    assertNotNull(flightDAO.create(flight));
  }

  @Test
  void shouldFindFlightById() throws ParseException {
    User user =
        new User("Anton", "Ivanovici", "anton.ivanoovici@gmail.com", "passenger", "634101463");
    assertNotNull(userDAO.create(user));
    Flight flight = new Flight(38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), user.getId());
    assertNotNull(flightDAO.create(flight));

    Flight foundFlight = flightDAO.findById(flight.getId());
    assertNotNull(foundFlight);
    assertEquals(foundFlight.getId(), flight.getId());
  }
}
