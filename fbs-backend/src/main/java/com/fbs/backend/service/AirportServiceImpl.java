package com.fbs.backend.service;

import com.fbs.backend.dao.AirportDAO;
import com.fbs.backend.domain.Airport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirportServiceImpl.class);

    private final AirportDAO airportDAO;

    public AirportServiceImpl(AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportDAO.create(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) {
        if(airport.getId() == null){
            return airportDAO.create(airport);
        } else {
        return airportDAO.update(airport);
        }
    }

    @Override
    public boolean deleteAirportById(Integer id) {
        if (id == null){
            LOGGER.error("Failed to delete the airport with id: " + id);
      return false;
    } else {
            return airportDAO.deleteById(id);
        }
  }

    @Override
    public Airport findAirportById(Integer id) {
        if (id == null){
            return null;
        }
        Airport airport =  airportDAO.findById(id);

        if(airport == null){
            LOGGER.error("Failed to find an airport with id: " + id);
            return  null;
        } else {
            return airport;
        }
    }

    @Override
    public Airport findAirportByName(String name) {
        if (name == null){
            return null;
        }

        Airport airport = airportDAO.findByName(name);

        if(airport == null){
            LOGGER.error("Failed to find an airport with the name: " + name);
        return null;
        } else{
            return airport;
        }
    }
}
