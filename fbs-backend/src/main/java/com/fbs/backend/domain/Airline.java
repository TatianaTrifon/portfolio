package com.fbs.backend.domain;

import java.util.Objects;

public class Airline {

    private Integer id;

    private String name;

    public Airline(String name) {
        this.name = name;
    }

    public Airline(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Airline() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(id, airline.id) && Objects.equals(name, airline.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
