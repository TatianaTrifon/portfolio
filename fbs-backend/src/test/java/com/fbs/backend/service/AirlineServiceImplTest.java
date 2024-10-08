package com.fbs.backend.service;

import com.fbs.backend.dao.AirlineDAOImpl;
import com.fbs.backend.domain.Airline;
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
class AirlineServiceImplTest {

  @Mock private AirlineDAOImpl airlineDAOImpl;

  private AirlineServiceImpl airlineServiceImpl;

  @BeforeEach
  void setUp() {
    airlineServiceImpl = new AirlineServiceImpl(airlineDAOImpl);
  }

  private Airline getTestAirline() {
    return new Airline(1, "Turkish Airlines");
  }

  @Test
  void shouldCreateAirline() {
    Airline airline = getTestAirline();

    Mockito.when(airlineDAOImpl.create(airline)).thenReturn(airline);
    airlineServiceImpl.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineDAOImpl.findById(airline.getId())).thenReturn(airline);
    Airline testAirline = airlineServiceImpl.findAirlineById(airline.getId());
    assertNotNull(testAirline);
    assertEquals(testAirline, airline);
  }

  @Test
  void shouldUpdateAirline() {
    Airline airline = getTestAirline();

    Mockito.when(airlineDAOImpl.create(airline)).thenReturn(airline);
    airlineServiceImpl.createAirline(airline);
    assertNotNull(airline);

    airline.setName("Tarom");

    Mockito.when(airlineDAOImpl.update(airline)).thenReturn(airline);
    Airline updatedAirline = airlineServiceImpl.updateAirline(airline);
    assertNotNull(updatedAirline);

    Mockito.when(airlineDAOImpl.findById(updatedAirline.getId())).thenReturn(updatedAirline);
    Airline foundAirline = airlineServiceImpl.findAirlineById(updatedAirline.getId());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, updatedAirline);
  }

  @Test
  void shouldCreateAirlineIfNotFound() {
    Airline airline = new Airline("Turkish Airlines");

    Mockito.lenient().when(airlineDAOImpl.findById(airline.getId())).thenReturn(null);
    assertNull(airlineServiceImpl.findAirlineById(airline.getId()));

    Mockito.when(airlineDAOImpl.create(airline)).thenReturn(airline);
    airline.setId(1);
    airlineServiceImpl.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineDAOImpl.findById(airline.getId())).thenReturn(airline);
    Airline testAirline = airlineServiceImpl.findAirlineById(airline.getId());
    assertNotNull(testAirline);
    assertEquals(testAirline, airline);
  }

  @Test
  void shouldDeleteAirlineById() {

    Airline airline = getTestAirline();

    Mockito.when(airlineDAOImpl.create(airline)).thenReturn(airline);
    airlineServiceImpl.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineDAOImpl.deleteById(airline.getId())).thenReturn(true);
    boolean isDeleted = airlineServiceImpl.deleteAirlineById(airline.getId());
    assertTrue(isDeleted);
  }

  @Test
  void shouldFindAirlineById() {
    Airline airline = getTestAirline();

    Mockito.when(airlineDAOImpl.create(airline)).thenReturn(airline);
    airlineServiceImpl.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineDAOImpl.findById(airline.getId())).thenReturn(airline);
    Airline foundAirline = airlineServiceImpl.findAirlineById(airline.getId());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, airline);
  }

  @Test
  void shouldFindAirlineByName() {
    Airline airline = getTestAirline();

    Mockito.when(airlineDAOImpl.create(airline)).thenReturn(airline);
    airlineServiceImpl.createAirline(airline);
    assertNotNull(airline);

    Mockito.when(airlineDAOImpl.findByName(airline.getName())).thenReturn(airline);
    Airline foundAirline = airlineServiceImpl.findAirlineByName(airline.getName());
    assertNotNull(foundAirline);
    assertEquals(foundAirline, airline);
  }
}
