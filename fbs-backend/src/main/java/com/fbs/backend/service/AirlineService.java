package com.fbs.backend.service;

import com.fbs.backend.domain.Airline;

public interface AirlineService {

    Airline createAirline(Airline airline);

    Airline updateAirline(Airline airline);

    boolean deleteAirlineById(Integer id);

    Airline findAirlineById(Integer id);

    Airline findAirlineByName(String name);




}
