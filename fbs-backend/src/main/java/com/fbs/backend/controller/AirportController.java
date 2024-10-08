package com.fbs.backend.controller;

import com.fbs.backend.domain.Airport;
import com.fbs.backend.service.AirportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/airport")
public class
AirportController {

  private final AirportService airportService;

  public AirportController(AirportService airportService) {
    this.airportService = airportService;
  }

  @PostMapping("/create")
  public Airport createAirport(@RequestBody Airport airport) {
    return airportService.createAirport(airport);
  }

  @PutMapping("/update")
  public Airport updateAirport(@RequestBody Airport airport) {
    return airportService.updateAirport(airport);
  }

  @DeleteMapping("/delete/{id}")
  public boolean deleteAirportById(@PathVariable Integer id) {
    return airportService.deleteAirportById(id);
  }

  @GetMapping("/find-by-id/{id}")
  public Airport findAirportById(@PathVariable Integer id) {
    return airportService.findAirportById(id);
  }

  @GetMapping("/find-by-name/{name}")
  public Airport findAirportByName(@PathVariable String name) {
    return airportService.findAirportByName(name);
  }
}
