package com.fbs.backend.dao;

import com.fbs.backend.domain.Flight;

public interface FlightDAO extends DAO<Flight> {

  Flight create(Flight flight);

  Flight update(Flight flight);

  boolean deleteById(Integer id);

  Flight findById(Integer id);

}
