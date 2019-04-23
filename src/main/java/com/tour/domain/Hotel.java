package com.tour.domain;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Hotel;

    private String Name_Hotel;

    private Integer ID_City;

    public Hotel() {
    }

    public Hotel(String name_Hotel, Integer ID_City) {
        Name_Hotel = name_Hotel;
        this.ID_City = ID_City;
    }

    public Integer getID_Hotel() {
        return ID_Hotel;
    }

    public void setID_Hotel(Integer ID_Hotel) {
        this.ID_Hotel = ID_Hotel;
    }

    public String getName_Hotel() {
        return Name_Hotel;
    }

    public void setName_Hotel(String name_Hotel) {
        Name_Hotel = name_Hotel;
    }

    public Integer getID_City() {
        return ID_City;
    }

    public void setID_City(Integer ID_City) {
        this.ID_City = ID_City;
    }
}
