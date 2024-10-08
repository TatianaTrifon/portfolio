package com.fbs.backend.controller;

import com.fbs.backend.domain.Airport;
import com.fbs.backend.service.AirportServiceImpl;
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
class AirportControllerTest {

  @Mock private AirportServiceImpl airportServiceImpl;

  private AirportController airportController;

  @BeforeEach
  void setUp() {
    airportController = new AirportController(airportServiceImpl);
  }

  private Airport getTestAirport() {
    return new Airport(1, "Linate Airport", "Italy", "Milan");
  }

  @Test
  void shouldCreateAirport() {
    Airport airport = getTestAirport();

    Mockito.when(airportServiceImpl.createAirport(airport)).thenReturn(airport);
    assertNotNull(airportController.createAirport(airport));

    Mockito.when(airportServiceImpl.findAirportById(airport.getId())).thenReturn(airport);
    Airport testAirport = airportController.findAirportById(airport.getId());
    assertNotNull(testAirport);
    assertEquals(testAirport, airport);
  }

  @Test
  void shouldUpdateAirport() {
    Airport airport = getTestAirport();

    Mockito.when(airportServiceImpl.createAirport(airport)).thenReturn(airport);
    assertNotNull(airportController.createAirport(airport));

    airport.setName("Another name");

    Mockito.when(airportServiceImpl.updateAirport(airport)).thenReturn(airport);
    Airport updatedAirport = airportController.updateAirport(airport);
    assertNotNull(updatedAirport);

    Mockito.when(airportServiceImpl.findAirportById(updatedAirport.getId()))
        .thenReturn(updatedAirport);
    Airport foundAirport = airportController.findAirportById(updatedAirport.getId());
    assertNotNull(foundAirport);
    assertEquals(foundAirport, updatedAirport);
  }

  @Test
  void shouldCreateAirportIfNotFound() {
    Airport airport = new Airport("Linate Airport", "Italy", "Milan");

    Mockito.when(airportServiceImpl.findAirportById(airport.getId())).thenReturn(null);
    assertNull(airportController.findAirportById(airport.getId()));

    Mockito.when(airportServiceImpl.createAirport(airport)).thenReturn(airport);
    airport.setId(1);
    assertNotNull(airportController.createAirport(airport));

    Mockito.when(airportServiceImpl.findAirportById(airport.getId())).thenReturn(airport);
    Airport testAirport = airportController.findAirportById(airport.getId());
    assertNotNull(testAirport);
    assertEquals(testAirport, airport);
  }

  @Test
  void shouldDeleteAirportById() {
    Airport airport = getTestAirport();

    Mockito.when(airportServiceImpl.createAirport(airport)).thenReturn(airport);
    assertNotNull(airportController.createAirport(airport));

    Mockito.when(airportServiceImpl.deleteAirportById(airport.getId())).thenReturn(true);
    assertTrue(airportController.deleteAirportById(airport.getId()));
  }

  @Test
  void findAirportById() {
    Airport airport = getTestAirport();

    Mockito.when(airportServiceImpl.createAirport(airport)).thenReturn(airport);
    assertNotNull(airportController.createAirport(airport));

    Mockito.when(airportServiceImpl.findAirportById(airport.getId())).thenReturn(airport);
    Airport foundAirport = airportController.findAirportById(airport.getId());
    assertNotNull(foundAirport);
    assertEquals(foundAirport, airport);
  }

  @Test
  void findAirportByName() {
    Airport airport = getTestAirport();

    Mockito.when(airportServiceImpl.createAirport(airport)).thenReturn(airport);
    assertNotNull(airportController.createAirport(airport));

    Mockito.when(airportServiceImpl.findAirportByName(airport.getName())).thenReturn(airport);
    Airport foundAirport = airportController.findAirportByName(airport.getName());
    assertNotNull(foundAirport);
    assertEquals(foundAirport, airport);
  }
}
