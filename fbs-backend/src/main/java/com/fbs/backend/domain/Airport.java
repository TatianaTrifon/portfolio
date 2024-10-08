package com.fbs.backend.domain;

import java.util.Objects;

public class Airport {

  private Integer id;

  private String name;

  private String country;

  private String city;

  public Airport(String name, String country, String city) {
    this.name = name;
    this.country = country;
    this.city = city;
  }

  public Airport(Integer id, String name, String country, String city) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.city = city;
  }

  public Airport() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Airport airport = (Airport) o;
    return Objects.equals(id, airport.id)
        && Objects.equals(name, airport.name)
        && Objects.equals(country, airport.country)
        && Objects.equals(city, airport.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country, city);
  }
}
