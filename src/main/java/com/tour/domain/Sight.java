package com.tour.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Sight;

    private String Name_Sight;

    private Integer ID_City;

    private Integer Local_Price;

    public Sight() {
    }

    public Sight(String name_Sight, Integer ID_City, Integer local_Price) {
        Name_Sight = name_Sight;
        this.ID_City = ID_City;
        Local_Price = local_Price;
    }

    public Integer getID_Sight() {
        return ID_Sight;
    }

    public void setID_Sight(Integer ID_Sight) {
        this.ID_Sight = ID_Sight;
    }

    public String getName_Sight() {
        return Name_Sight;
    }

    public void setName_Sight(String name_Sight) {
        Name_Sight = name_Sight;
    }

    public Integer getID_City() {
        return ID_City;
    }

    public void setID_City(Integer ID_City) {
        this.ID_City = ID_City;
    }

    public Integer getLocal_Price() {
        return Local_Price;
    }

    public void setLocal_Price(Integer local_Price) {
        Local_Price = local_Price;
    }
}
