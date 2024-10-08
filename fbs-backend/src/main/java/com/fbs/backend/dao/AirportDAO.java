package com.fbs.backend.dao;

import com.fbs.backend.domain.Airport;

public interface AirportDAO extends DAO<Airport> {

  Airport create(Airport airport);

  Airport update(Airport airport);

  boolean deleteById(Integer id);

  Airport findById(Integer id);

  Airport findByName(String name);
}
