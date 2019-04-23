package com.tour.domain;

import javax.persistence.*;

@Entity
@Table(name = "City_Tour")
public class City_Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_City_Tour;

    private Integer ID_City;

    private Integer ID_Sight;

    private Integer Local_Price;

    private String Time_Start;

    private String Time_End;

    public City_Tour() {
    }

    public City_Tour(Integer ID_City, Integer ID_Sight, Integer local_Price, String time_Start, String time_End) {
        this.ID_City = ID_City;
        this.ID_Sight = ID_Sight;
        Local_Price = local_Price;
        Time_Start = time_Start;
        Time_End = time_End;
    }

    public Integer getID_City_Tour() {
        return ID_City_Tour;
    }

    public void setID_City_Tour(Integer ID_City_Tour) {
        this.ID_City_Tour = ID_City_Tour;
    }

    public Integer getID_City() {
        return ID_City;
    }

    public void setID_City(Integer ID_City) {
        this.ID_City = ID_City;
    }

    public Integer getID_Sight() {
        return ID_Sight;
    }

    public void setID_Sight(Integer ID_Sight) {
        this.ID_Sight = ID_Sight;
    }

    public Integer getLocal_Price() {
        return Local_Price;
    }

    public void setLocal_Price(Integer local_Price) {
        Local_Price = local_Price;
    }

    public String getTime_Start() {
        return Time_Start;
    }

    public void setTime_Start(String time_Start) {
        Time_Start = time_Start;
    }

    public String getTime_End() {
        return Time_End;
    }

    public void setTime_End(String time_End) {
        Time_End = time_End;
    }
}
