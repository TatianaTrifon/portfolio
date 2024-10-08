package com.fbs.backend.service;

import com.fbs.backend.dao.AirlineDAO;
import com.fbs.backend.dao.AirlineDAOImpl;
import com.fbs.backend.domain.Airline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AirlineServiceImpl implements AirlineService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AirlineServiceImpl.class);

  private final AirlineDAO airlineDAO;

  public AirlineServiceImpl(AirlineDAO airlineDAO) {
    this.airlineDAO = airlineDAO;
  }

  @Override
  public Airline createAirline(Airline airline) {
    return airlineDAO.create(airline);
  }

  @Override
  public Airline updateAirline(Airline airline) {
    if (airline.getId() == null) {
      return airlineDAO.create(airline);
    } else {
      return airlineDAO.update(airline);
    }
  }

  @Override
  public boolean deleteAirlineById(Integer id) {
    if (id == null) {
      LOGGER.error("Failed to delete the airline with id: " + id);
      return false;
    } else {
      return airlineDAO.deleteById(id);
    }
  }

  @Override
  public Airline findAirlineById(Integer id) {
    if (id == null) {
      return null;
    }
    Airline airline = airlineDAO.findById(id);

    if (airline == null) {
      LOGGER.error("Failed to find an airline with id: " + id);
      return null;
    } else {
      return airline;
    }
  }

  @Override
  public Airline findAirlineByName(String name) {
    if (name == null) {
      return null;
    }
    Airline airline = airlineDAO.findByName(name);
    if (airline == null) {
      LOGGER.error("Failed to find an airline with name:  " + name);
      return null;
    } else {
      return airline;
    }
  }
}
