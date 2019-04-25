package com.tour.domain;

import javax.persistence.*;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Tour;

    @Column(name = "Total_Price")
    private Integer price;

    private String Date_Start;

    private String Date_End;

    public Tour() {
    }

    public Tour(Integer price, String date_Start, String date_End) {
        this.price = price;
        Date_Start = date_Start;
        Date_End = date_End;
    }

    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate_Start() {
        return Date_Start;
    }

    public void setDate_Start(String date_Start) {
        Date_Start = date_Start;
    }

    public String getDate_End() {
        return Date_End;
    }

    public void setDate_End(String date_End) {
        Date_End = date_End;
    }
}
