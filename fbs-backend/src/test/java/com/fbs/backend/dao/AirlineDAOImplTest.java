package com.fbs.backend.dao;

import com.fbs.backend.domain.Airline;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AirlineDAOImplTest {
@Autowired
   private AirlineDAO airlineDAO;


    @Test
    void shouldCreateAirline() {
        Airline airline = new Airline("Turkish Airlines");
        airlineDAO.create(airline);
        assertNotNull(airline);

        Airline testAirline = airlineDAO.findById(airline.getId());
        assertNotNull(testAirline);
        assertEquals(testAirline,airline);

        boolean isDeleted = airlineDAO.deleteById(airline.getId());
        assertTrue(isDeleted);

    }

    private Airline getTestAirline(){
        return new Airline("Turkish Airlines");
    }

    @Test
    void shouldUpdateAirline() {
        Airline airline = getTestAirline();
        airlineDAO.create(airline);
        assertNotNull(airline);

        airline.setName("Tarom");

        Airline updatedAirline = airlineDAO.update(airline);
        assertNotNull(updatedAirline);

        Airline foundAirline = airlineDAO.findById(updatedAirline.getId());
        assertNotNull(foundAirline);
        assertEquals(foundAirline,updatedAirline);

        boolean isDeleted = airlineDAO.deleteById(airline.getId());
        assertTrue(isDeleted);

      }

      @Test
      void shouldCreateAirlineIfNotFound(){
          Airline airline = getTestAirline();
          assertNull(airlineDAO.findById(airline.getId()));

          airlineDAO.create(airline);
          assertNotNull(airline);

          boolean isDeleted = airlineDAO.deleteById(airline.getId());
          assertTrue(isDeleted);


      }

    @Test
    void shouldDeleteAirlineById() {
        Airline airline = getTestAirline();
        airlineDAO.create(airline);
        assertNotNull(airline);

        boolean isDeleted = airlineDAO.deleteById(airline.getId());
        assertTrue(isDeleted);

      }

    @Test
    void shouldFindAirlineById() {
        Airline airline = getTestAirline();
        airlineDAO.create(airline);
        assertNotNull(airline);

        Airline foundAirline = airlineDAO.findById(airline.getId());
        assertNotNull(foundAirline);
        assertEquals(foundAirline,airline);

        boolean isDeleted = airlineDAO.deleteById(airline.getId());
        assertTrue(isDeleted);



      }

    @Test
    void shouldFindAirlineByName() {
        Airline airline = getTestAirline();
        airlineDAO.create(airline);
        assertNotNull(airline);

        Airline foundAirline = airlineDAO.findByName(airline.getName());
        assertNotNull(foundAirline);
        assertEquals(foundAirline,airline);

        boolean isDeleted = airlineDAO.deleteById(airline.getId());
        assertTrue(isDeleted);


      }
}