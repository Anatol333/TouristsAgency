package com.tour.domain;


import javax.persistence.*;

@Entity
@Table(name = "Services")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Service;

    private String Name_Service;

    private Integer Price_Service;

    public Services() {
    }

    public Services(String name_Service, Integer price_Service) {
        Name_Service = name_Service;
        Price_Service = price_Service;
    }

    public Integer getID_Service() {
        return ID_Service;
    }

    public void setID_Service(Integer ID_Service) {
        this.ID_Service = ID_Service;
    }

    public String getName_Service() {
        return Name_Service;
    }

    public void setName_Service(String name_Service) {
        Name_Service = name_Service;
    }

    public Integer getPrice_Service() {
        return Price_Service;
    }

    public void setPrice_Service(Integer price_Service) {
        Price_Service = price_Service;
    }
}
