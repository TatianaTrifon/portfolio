package com.fbs.backend.controller;

import com.fbs.backend.domain.Airline;
import com.fbs.backend.service.AirlineService;
import com.fbs.backend.service.AirlineServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/airline")
public class AirlineController {

  private final AirlineService airlineService;

  public AirlineController(AirlineService airlineService) {
    this.airlineService = airlineService;
  }

  @PostMapping("/create")
  Airline createAirline(@RequestBody Airline airline) {
    return airlineService.createAirline(airline);
  }

  @PutMapping("/update")
  Airline updateAirline(@RequestBody Airline airline) {
    return airlineService.updateAirline(airline);
  }

  @DeleteMapping("/delete/{id}")
  boolean deleteAirlineById(@PathVariable Integer id) {
    return airlineService.deleteAirlineById(id);
  }

  @GetMapping("/find-by-id/{id}")
  Airline findAirlineById(@PathVariable Integer id) {
    return airlineService.findAirlineById(id);
  }

  @GetMapping("/find-by-name/{name}")
  Airline findAirlineByName(@PathVariable String name) {
    return airlineService.findAirlineByName(name);
  }
}
