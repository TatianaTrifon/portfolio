package com.fbs.backend.service;

import com.fbs.backend.dao.AirportDAOImpl;
import com.fbs.backend.domain.Airport;
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
class AirportServiceImplTest {

  @Mock private AirportDAOImpl airportDAOImpl;

  private AirportServiceImpl airportServiceImpl;

  @BeforeEach
  void setUp() {
    airportServiceImpl = new AirportServiceImpl(airportDAOImpl);
  }

  private Airport getTestAirport() {
    return new Airport(1, "Linate Airport", "Italy", "Milan");
  }

  @Test
  void shouldCreateAirport() {
    Airport airport = getTestAirport();

    Mockito.when(airportDAOImpl.create(airport)).thenReturn(airport);
    airportServiceImpl.createAirport(airport);
    assertNotNull(airport);

    Mockito.when(airportDAOImpl.findById(airport.getId())).thenReturn(airport);
    Airport testAirport = airportServiceImpl.findAirportById(airport.getId());
    assertNotNull(testAirport);
    assertEquals(testAirport, airport);
  }

  @Test
  void shouldUpdateAirport() {
    Airport airport = getTestAirport();

    Mockito.when(airportDAOImpl.create(airport)).thenReturn(airport);
    airportServiceImpl.createAirport(airport);
    assertNotNull(airport);

    airport.setName("Another name");

    Mockito.when(airportDAOImpl.update(airport)).thenReturn(airport);
    Airport updatedAirport = airportServiceImpl.updateAirport(airport);
    assertNotNull(updatedAirport);

    Mockito.when(airportDAOImpl.findById(updatedAirport.getId())).thenReturn(updatedAirport);
    Airport foundAirport = airportServiceImpl.findAirportById(updatedAirport.getId());
    assertNotNull(foundAirport);
    assertEquals(foundAirport, updatedAirport);
  }

  @Test
  void shouldCreateAirportIfNotFound() {
    Airport airport = new Airport("Linate Airport", "Italy", "Milan");

    Mockito.lenient().when(airportDAOImpl.findById(airport.getId())).thenReturn(null);
    assertNull(airportServiceImpl.findAirportById(airport.getId()));

    Mockito.when(airportDAOImpl.create(airport)).thenReturn(airport);
    airport.setId(1);
    airportServiceImpl.createAirport(airport);
    assertNotNull(airport);

    Mockito.when(airportDAOImpl.findById(airport.getId())).thenReturn(airport);
    Airport testAirport = airportServiceImpl.findAirportById(airport.getId());
    assertNotNull(testAirport);
    assertEquals(testAirport, airport);
  }

  @Test
  void shouldDeleteAirportById() {
    Airport airport = getTestAirport();

    Mockito.when(airportDAOImpl.create(airport)).thenReturn(airport);
    airportServiceImpl.createAirport(airport);
    assertNotNull(airport);

    Mockito.when(airportDAOImpl.deleteById(airport.getId())).thenReturn(true);
    assertTrue(airportServiceImpl.deleteAirportById(airport.getId()));
  }

  @Test
  void shouldFindAirportById() {
    Airport airport = getTestAirport();

    Mockito.when(airportDAOImpl.create(airport)).thenReturn(airport);
    assertNotNull(airportServiceImpl.createAirport(airport));

    Mockito.when(airportDAOImpl.findById(airport.getId())).thenReturn(airport);
    Airport foundAirport = airportServiceImpl.findAirportById(airport.getId());
    assertNotNull(foundAirport);
    assertEquals(foundAirport, airport);
  }

  @Test
  void shouldFindAirportByName() {
    Airport airport = getTestAirport();

    Mockito.when(airportDAOImpl.create(airport)).thenReturn(airport);
    assertNotNull(airportServiceImpl.createAirport(airport));

    Mockito.when(airportDAOImpl.findByName(airport.getName())).thenReturn(airport);
    Airport foundAirport = airportServiceImpl.findAirportByName(airport.getName());
    assertNotNull(foundAirport);
    assertEquals(foundAirport, airport);
  }
}
