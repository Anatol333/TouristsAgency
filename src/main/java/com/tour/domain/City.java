package com.tour.domain;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_City;

    private Integer ID_Country;

    private String City_Name;

    public City() {
    }

    public City(Integer ID_Country, String city_Name) {
        this.ID_Country = ID_Country;
        City_Name = city_Name;
    }

    public Integer getID_City() {
        return ID_City;
    }

    public void setID_City(Integer ID_City) {
        this.ID_City = ID_City;
    }

    public Integer getID_Country() {
        return ID_Country;
    }

    public void setID_Country(Integer ID_Country) {
        this.ID_Country = ID_Country;
    }

    public String getCity_Name() {
        return City_Name;
    }

    public void setCity_Name(String city_Name) {
        City_Name = city_Name;
    }
}
