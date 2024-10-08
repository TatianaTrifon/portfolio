package com.fbs.backend.controller;

import com.fbs.backend.domain.Airline;
import com.fbs.backend.service.AirlineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AirlineControllerTest {

  @Mock private AirlineServiceImpl airlineServiceImpl;

  private AirlineController airlineController;

  @BeforeEach
  void setUp() {
    airlineController = new AirlineController(airlineServiceImpl);
  }

  private Airline getTestAirline() {
    return new Airline(1, "Turkish Airlines");
  }

  @Test
  void shouldCreateAirline() {
    Airline airline = getTestAirline();

    Mockito.when(airlineServiceImpl.createAirline(airline)).thenReturn(airline);
    airlineController.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineServiceImpl.findAirlineById(airline.getId())).thenReturn(airline);
    Airline testAirline = airlineController.findAirlineById(airline.getId());
    assertNotNull(testAirline);
    assertEquals(testAirline, airline);
  }

  @Test
  void shouldUpdateAirline() {
    Airline airline = getTestAirline();

    Mockito.when(airlineServiceImpl.createAirline(airline)).thenReturn(airline);
    airlineController.createAirline(airline);
    assertNotNull(airline);

    airline.setName("Tarom");

    Mockito.when(airlineServiceImpl.updateAirline(airline)).thenReturn(airline);
    Airline updatedAirline = airlineController.updateAirline(airline);
    assertNotNull(updatedAirline);

    Mockito.when(airlineServiceImpl.findAirlineById(updatedAirline.getId()))
        .thenReturn(updatedAirline);
    Airline foundAirline = airlineController.findAirlineById(updatedAirline.getId());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, updatedAirline);
  }

  @Test
  void shouldCreateAirlineIfNotFound() {
    Airline airline = new Airline("Turkish Airlines");

    Mockito.when(airlineServiceImpl.findAirlineById(airline.getId())).thenReturn(null);
    assertNull(airlineController.findAirlineById(airline.getId()));

    Mockito.when(airlineServiceImpl.createAirline(airline)).thenReturn(airline);
    airline.setId(1);
    airlineController.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineServiceImpl.findAirlineById(airline.getId())).thenReturn(airline);
    Airline foundAirline = airlineController.findAirlineById(airline.getId());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, airline);
  }

  @Test
  void shouldDeleteAirlineById() {
    Airline airline = getTestAirline();

    Mockito.when(airlineServiceImpl.createAirline(airline)).thenReturn(airline);
    airlineController.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineServiceImpl.deleteAirlineById(airline.getId())).thenReturn(true);
    boolean isDeleted = airlineController.deleteAirlineById(airline.getId());
    assertTrue(isDeleted);
  }

  @Test
  void shouldFindAirlineById() {
    Airline airline = getTestAirline();

    Mockito.when(airlineServiceImpl.createAirline(airline)).thenReturn(airline);
    airlineController.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineServiceImpl.findAirlineById(airline.getId())).thenReturn(airline);
    Airline foundAirline = airlineController.findAirlineById(airline.getId());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, airline);
  }

  @Test
  void shouldFindAirlineByName() {
    Airline airline = getTestAirline();

    Mockito.when(airlineServiceImpl.createAirline(airline)).thenReturn(airline);
    airlineController.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineServiceImpl.findAirlineByName(airline.getName())).thenReturn(airline);
    Airline foundAirline = airlineController.findAirlineByName(airline.getName());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, airline);
  }
}
