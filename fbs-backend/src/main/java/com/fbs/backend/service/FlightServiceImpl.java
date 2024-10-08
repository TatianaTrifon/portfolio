package com.fbs.backend.service;

import com.fbs.backend.dao.FlightDAO;
import com.fbs.backend.domain.Flight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

  private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

  private final FlightDAO flightDAO;

  public FlightServiceImpl(FlightDAO flightDAO) {
    this.flightDAO = flightDAO;
  }

  @Override
  public Flight createFlight(Flight flight) {
    return flightDAO.create(flight);
  }

  @Override
  public Flight updateFlight(Flight flight) {
    if (flight.getId() == null) {
      LOGGER.error("Failed to update the flight due to null id");
      return null;
    } else {
      return flightDAO.update(flight);
    }
  }

  @Override
  public boolean deleteFlightById(Integer id) {
    if (id == null) {
      return false;
    } else {
      return flightDAO.deleteById(id);
    }
  }

  @Override
  public Flight findFlightById(Integer id) {
    Flight flight = flightDAO.findById(id);

    if (flight == null) {
      LOGGER.error("Failed to find a flight due to wrong id: " + id);
      return null;
    } else {
      return flight;
    }
  }
}
