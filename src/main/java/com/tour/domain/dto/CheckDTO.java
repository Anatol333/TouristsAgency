package com.tour.domain.dto;

import com.tour.domain.City_Tour;
import com.tour.domain.Room_Service;

import java.util.List;

public class CheckDTO {

    // Tour

    private List<Integer> ID_Sight;

    private String Custom_Price;

    private String Custom_Date_Start;

    private String Custom_Date_End;


    // Hotel

    private Integer ID_Hotel;

    private Integer ID_Room;

    private Integer ID_Service;


    public CheckDTO() {
    }

    public CheckDTO(List<Integer> ID_Sight) {
        this.ID_Sight = ID_Sight;
    }

    public List<Integer> getID_Sight() {
        return ID_Sight;
    }

    public void setID_Sight(List<Integer> ID_Sight) {
        this.ID_Sight = ID_Sight;
    }

    public CheckDTO(List<Integer> ID_Sight, String custom_Price) {
        this.ID_Sight = ID_Sight;
        Custom_Price = custom_Price;
    }

    public String getCustom_Price() {
        return Custom_Price;
    }

    public void setCustom_Price(String custom_Price) {
        Custom_Price = custom_Price;
    }

    public String getCustom_Date_Start() {
        return Custom_Date_Start;
    }

    public void setCustom_Date_Start(String custom_Date_Start) {
        Custom_Date_Start = custom_Date_Start;
    }

    public String getCustom_Date_End() {
        return Custom_Date_End;
    }

    public void setCustom_Date_End(String custom_Date_End) {
        Custom_Date_End = custom_Date_End;
    }

    public Integer getID_Hotel() {
        return ID_Hotel;
    }

    public void setID_Hotel(Integer ID_Hotel) {
        this.ID_Hotel = ID_Hotel;
    }

    public Integer getID_Room() {
        return ID_Room;
    }

    public void setID_Room(Integer ID_Room) {
        this.ID_Room = ID_Room;
    }

    public Integer getID_Service() {
        return ID_Service;
    }

    public void setID_Service(Integer ID_Service) {
        this.ID_Service = ID_Service;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Integer i : ID_Sight) {
            str.append(i);
        }
        return str.toString();
    }
}
