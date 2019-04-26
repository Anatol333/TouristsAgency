package com.tour.domain.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

public class TourDTO {

    private Integer ID_Tour;
    private Integer ID_City;
    private String City_Name;

    public TourDTO() {
    }

    public TourDTO(Integer ID_Tour, Integer ID_City, String city_Name) {
        this.ID_Tour = ID_Tour;
        this.ID_City = ID_City;
        City_Name = city_Name;
    }


    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }

    public Integer getID_City() {
        return ID_City;
    }

    public void setID_City(Integer ID_City) {
        this.ID_City = ID_City;
    }

    public String getCity_Name() {
        return City_Name;
    }

    public void setCity_Name(String city_Name) {
        City_Name = city_Name;
    }
}
