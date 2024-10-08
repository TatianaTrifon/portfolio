package com.fbs.backend.service;

import com.fbs.backend.domain.Airport;

public interface AirportService {

    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    boolean deleteAirportById(Integer id);

    Airport findAirportById (Integer id);

    Airport findAirportByName(String name);
}
