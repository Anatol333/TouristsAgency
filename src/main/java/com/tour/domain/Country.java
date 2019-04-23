package com.tour.domain;

import javax.persistence.*;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Country;

    private String Name_County;

    public Country() {
    }

    public Country(String name_County) {
        Name_County = name_County;
    }

    public Integer getID_Country() {
        return ID_Country;
    }

    public void setID_Country(Integer ID_Country) {
        this.ID_Country = ID_Country;
    }

    public String getName_County() {
        return Name_County;
    }

    public void setName_County(String name_County) {
        Name_County = name_County;
    }
}
