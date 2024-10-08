package com.fbs.backend.dao;

import com.fbs.backend.domain.Airport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AirportDAOImplTest {

@Autowired
    private AirportDAO airportDAO;

    private Airport getTestAirport(){
        return new Airport("Linate Airport","Italy","Milan");
    }


    @Test
    void shouldCreateAirport() {
        Airport airport = getTestAirport();

        airportDAO.create(airport);
        assertNotNull(airport);

        Airport testAirport = airportDAO.findById(airport.getId());
        assertNotNull(testAirport);
        assertEquals(testAirport,airport);

        boolean isDeleted = airportDAO.deleteById(airport.getId());
        assertTrue(isDeleted);
      }

    @Test
    void shouldUpdateAirport() {
        Airport airport = getTestAirport();
        airportDAO.create(airport);
        assertNotNull(airport);

        airport.setName("Another name");

        Airport updatedAirport = airportDAO.update(airport);
        assertNotNull(updatedAirport);

        Airport foundAirport = airportDAO.findById(updatedAirport.getId());
        assertNotNull(foundAirport);
        assertEquals(foundAirport,updatedAirport);

        boolean isDeleted = airportDAO.deleteById(airport.getId());
        assertTrue(isDeleted);

      }

      @Test
      void shouldCreateAirportIfNotFound(){
        Airport airport = getTestAirport();

        assertNull(airportDAO.findById(airport.getId()));

        airportDAO.create(airport);
        assertNotNull(airport);

        Airport testAirport = airportDAO.findById(airport.getId());
        assertNotNull(testAirport);
        assertEquals(testAirport,airport);

        boolean isDeleted = airportDAO.deleteById(airport.getId());
        assertTrue(isDeleted);

      }

    @Test
    void shouldDeleteAirportById() {
        Airport airport = getTestAirport();
        airportDAO.create(airport);
        assertNotNull(airport);

        boolean isDeleted = airportDAO.deleteById(airport.getId());
        assertTrue(isDeleted);

      }

    @Test
    void shouldFindAirportById() {
        Airport airport = getTestAirport();
        airportDAO.create(airport);
        assertNotNull(airport);

        Airport foundAirport = airportDAO.findById(airport.getId());
        assertNotNull(foundAirport);
        assertEquals(foundAirport,airport);

        boolean isDeleted = airportDAO.deleteById(airport.getId());
        assertTrue(isDeleted);

      }

    @Test
    void shouldFindAirportByName() {
        Airport airport = getTestAirport();
        airportDAO.create(airport);
        assertNotNull(airport);

        Airport foundAirport = airportDAO.findByName(airport.getName());
        assertNotNull(foundAirport);
        assertEquals(foundAirport,airport);

        boolean isDeleted = airportDAO.deleteById(airport.getId());
        assertTrue(isDeleted);

      }
}