package com.tour.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Tour;

    private Integer Total_Price;

    private String Date_Start;

    private String Date_End;

    public Tour() {
    }

    public Tour(Integer total_Price, String date_Start, String date_End) {
        Total_Price = total_Price;
        Date_Start = date_Start;
        Date_End = date_End;
    }

    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }

    public Integer getTotal_Price() {
        return Total_Price;
    }

    public void setTotal_Price(Integer total_Price) {
        Total_Price = total_Price;
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
