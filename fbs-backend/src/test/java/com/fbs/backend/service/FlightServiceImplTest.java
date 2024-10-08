package com.fbs.backend.service;

import com.fbs.backend.dao.FlightDAOImpl;
import com.fbs.backend.dao.UserDAOImpl;
import com.fbs.backend.domain.Flight;
import com.fbs.backend.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {

  @Mock FlightDAOImpl flightDAOImpl;

  FlightServiceImpl flightServiceImpl;

  @BeforeEach
  void setUp() {
    flightServiceImpl = new FlightServiceImpl(flightDAOImpl);
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
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightDAOImpl.create(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightDAOImpl.findById(flight.getId())).thenReturn(flight);
    Flight testFlight = flightServiceImpl.findFlightById(flight.getId());

    assertNotNull(testFlight);
    assertEquals(testFlight, flight);
  }

  @Test
  void shouldUpdateFlight() throws ParseException {
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightDAOImpl.create(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    String newTimeStart = "2023-10-20 06:00:00";
    String newTimeEnd = "2023-10-20 09:00:00";

    java.sql.Timestamp newTimestampStart = java.sql.Timestamp.valueOf(newTimeStart);
    java.sql.Timestamp newTimestampEnd = java.sql.Timestamp.valueOf(newTimeEnd);

    flight.setTimeStart(newTimestampStart);
    flight.setTimeEnd(newTimestampEnd);

    Mockito.when(flightDAOImpl.update(flight)).thenReturn(flight);
    Flight updatedFlight = flightServiceImpl.updateFlight(flight);
    assertNotNull(updatedFlight);

    Mockito.when(flightDAOImpl.findById(flight.getId())).thenReturn(flight);
    Flight testFlight = flightServiceImpl.findFlightById(updatedFlight.getId());
    assertNotNull(testFlight);
    assertEquals(testFlight, updatedFlight);
  }

  @Test
  void shouldCreateFlightIfNotFound() throws ParseException {
    Flight flight = new Flight(38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightDAOImpl.findById(flight.getId())).thenReturn(null);
    assertNull(flightServiceImpl.findFlightById(flight.getId()));

    Mockito.when(flightDAOImpl.create(flight)).thenReturn(flight);
    flight.setId(1);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightDAOImpl.findById(flight.getId())).thenReturn(flight);
    Flight testFlight = flightServiceImpl.findFlightById(flight.getId());
    assertNotNull(testFlight);
    assertEquals(testFlight, flight);
  }

  @Test
  void shouldDeleteFlightById() throws ParseException {
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightDAOImpl.create(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightDAOImpl.deleteById(flight.getId())).thenReturn(true);
    assertTrue(flightServiceImpl.deleteFlightById(flight.getId()));
  }

  @Test
  void shouldFindFlightById() throws ParseException {
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightDAOImpl.create(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightDAOImpl.findById(flight.getId())).thenReturn(flight);
    Flight foundFlight = flightServiceImpl.findFlightById(flight.getId());
    assertNotNull(foundFlight);
    assertEquals(foundFlight.getId(), flight.getId());
  }
}
