package com.fbs.backend.dao;

import com.fbs.backend.domain.Airline;

public interface AirlineDAO extends DAO<Airline> {

    Airline create (Airline airline);

    Airline update (Airline airline);

    boolean deleteById (Integer id);

    Airline findById (Integer id);

    Airline findByName (String name);



}
