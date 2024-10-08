package com.fbs.backend.controller;

import com.fbs.backend.domain.Flight;
import com.fbs.backend.domain.User;
import com.fbs.backend.service.FlightServiceImpl;
import com.fbs.backend.service.UserServiceImpl;
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
class FlightControllerTest {

  @Mock FlightServiceImpl flightServiceImpl;

  FlightController flightController;

  @BeforeEach
  void setUp() {
    flightController = new FlightController(flightServiceImpl);
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

    Mockito.when(flightServiceImpl.createFlight(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightServiceImpl.findFlightById(flight.getId())).thenReturn(flight);
    Flight testFlight = flightController.findFlightById(flight.getId());
    assertNotNull(testFlight);
    assertEquals(testFlight, flight);
  }

  @Test
  void updateFlight() throws ParseException {
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightServiceImpl.createFlight(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    String newTimeStart = "2023-10-20 06:00:00";
    String newTimeEnd = "2023-10-20 09:00:00";

    java.sql.Timestamp newTimestampStart = java.sql.Timestamp.valueOf(newTimeStart);
    java.sql.Timestamp newTimestampEnd = java.sql.Timestamp.valueOf(newTimeEnd);

    flight.setTimeStart(newTimestampStart);
    flight.setTimeEnd(newTimestampEnd);

    Mockito.when(flightServiceImpl.updateFlight(flight)).thenReturn(flight);
    Flight updatedFlight = flightController.updateFlight(flight);
    assertNotNull(updatedFlight);

    Mockito.when(flightServiceImpl.findFlightById(flight.getId())).thenReturn(flight);
    Flight testFlight = flightController.findFlightById(updatedFlight.getId());
    assertNotNull(testFlight);
    assertEquals(testFlight, updatedFlight);
  }

  @Test
  void deleteFlightById() throws ParseException {
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightServiceImpl.createFlight(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightServiceImpl.deleteFlightById(flight.getId())).thenReturn(true);
    assertTrue(flightController.deleteFlightById(flight.getId()));

    Mockito.when(flightServiceImpl.findFlightById(flight.getId())).thenReturn(null);
    assertNull(flightController.findFlightById(flight.getId()));
  }

  @Test
  void findFlightById() throws ParseException {
    Flight flight = new Flight(1, 38, "Economy", 31, 32, getTimeStart(), getTimeEnd(), 1);

    Mockito.when(flightServiceImpl.createFlight(flight)).thenReturn(flight);
    assertNotNull(flightServiceImpl.createFlight(flight));

    Mockito.when(flightServiceImpl.findFlightById(flight.getId())).thenReturn(flight);
    Flight foundFlight = flightController.findFlightById(flight.getId());
    assertNotNull(foundFlight);
    assertEquals(foundFlight, flight);
  }
}
