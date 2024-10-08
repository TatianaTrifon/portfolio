package com.fbs.backend.service;

import com.fbs.backend.domain.Flight;

public interface FlightService {

  Flight createFlight(Flight flight);

  Flight updateFlight(Flight flight);

  boolean deleteFlightById(Integer id);

  Flight findFlightById(Integer id);
}
