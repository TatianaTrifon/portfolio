package com.fbs.backend.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

  private Integer id;

  private Integer airlineId;

  private String seatClass;

  private Integer departureAirportId;

  private Integer destinationAirportId;

  private Timestamp timeStart;

  private Timestamp timeEnd;

  private Integer userId;

  private String usersFirstName;

  private String usersLastName;

  public Flight(
      Integer id,
      Integer airlineId,
      String seatClass,
      Integer departureAirportId,
      Integer destinationAirportId,
      Timestamp timeStart,
      Timestamp timeEnd,
      Integer userId,
      String usersFirstName,
      String usersLastName) {
    this.id = id;
    this.airlineId = airlineId;
    this.seatClass = seatClass;
    this.departureAirportId = departureAirportId;
    this.destinationAirportId = destinationAirportId;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.userId = userId;
    this.usersFirstName = usersFirstName;
    this.usersLastName = usersLastName;
  }

  public Flight(
      Integer airlineId,
      String seatClass,
      Integer departureAirportId,
      Integer destinationAirportId,
      Timestamp timeStart,
      Timestamp timeEnd,
      Integer userId) {
    this.airlineId = airlineId;
    this.seatClass = seatClass;
    this.departureAirportId = departureAirportId;
    this.destinationAirportId = destinationAirportId;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.userId = userId;
  }

  public Flight(
      Integer id,
      Integer airlineId,
      String seatClass,
      Integer departureAirportId,
      Integer destinationAirportId,
      Timestamp timeStart,
      Timestamp timeEnd,
      Integer userId) {
    this.id = id;
    this.airlineId = airlineId;
    this.seatClass = seatClass;
    this.departureAirportId = departureAirportId;
    this.destinationAirportId = destinationAirportId;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.userId = userId;
  }

  public Flight() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(Integer airlineId) {
    this.airlineId = airlineId;
  }

  public String getSeatClass() {
    return seatClass;
  }

  public void setSeatClass(String seatClass) {
    this.seatClass = seatClass;
  }

  public Integer getDepartureAirportId() {
    return departureAirportId;
  }

  public void setDepartureAirportId(Integer departureAirportId) {
    this.departureAirportId = departureAirportId;
  }

  public Integer getDestinationAirportId() {
    return destinationAirportId;
  }

  public void setDestinationAirportId(Integer destinationAirportId) {
    this.destinationAirportId = destinationAirportId;
  }

  public Timestamp getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(Timestamp timeStart) {
    this.timeStart = timeStart;
  }

  public Timestamp getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(Timestamp timeEnd) {
    this.timeEnd = timeEnd;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUsersFirstName() {
    return usersFirstName;
  }

  public void setUsersFirstName(String usersFirstName) {
    this.usersFirstName = usersFirstName;
  }

  public String getUsersLastName() {
    return usersLastName;
  }

  public void setUsersLastName(String usersLastName) {
    this.usersLastName = usersLastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Flight flight = (Flight) o;
    return Objects.equals(id, flight.id)
        && Objects.equals(airlineId, flight.airlineId)
        && Objects.equals(seatClass, flight.seatClass)
        && Objects.equals(departureAirportId, flight.departureAirportId)
        && Objects.equals(destinationAirportId, flight.destinationAirportId)
        && Objects.equals(timeStart, flight.timeStart)
        && Objects.equals(timeEnd, flight.timeEnd)
        && Objects.equals(userId, flight.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        airlineId,
        seatClass,
        departureAirportId,
        destinationAirportId,
        timeStart,
        timeEnd,
        userId);
  }
}
