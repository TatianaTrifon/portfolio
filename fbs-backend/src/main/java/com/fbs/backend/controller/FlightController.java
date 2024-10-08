package com.fbs.backend.controller;

import com.fbs.backend.domain.Flight;
import com.fbs.backend.service.FlightService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/flight")
public class FlightController {

  private final FlightService flightService;

  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  @PostMapping("/create")
  public Flight createFlight(@RequestBody Flight flight) {
    return flightService.createFlight(flight);
  }

  @PutMapping("/update")
  public Flight updateFlight(@RequestBody Flight flight) {
    return flightService.updateFlight(flight);
  }

  @DeleteMapping("/delete/{id}")
  public boolean deleteFlightById(@PathVariable Integer id) {
    return flightService.deleteFlightById(id);
  }

  @GetMapping("/find/find-by-id/{id}")
  public Flight findFlightById(@PathVariable Integer id) {
    return flightService.findFlightById(id);
  }
}
