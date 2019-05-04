package com.tour.domain.dto;

public class HotelDTO {

    private Integer ID_Hotel;

    private Integer ID_Room;

    private Integer ID_Service;

    private String Name_Hotel;

    private String Name_Service;

    private Integer Price_Service;

    public HotelDTO() {
    }

    public HotelDTO(Integer ID_Hotel, Integer ID_Room, Integer ID_Service, String name_Hotel, String name_Service, Integer price_Service) {
        this.ID_Hotel = ID_Hotel;
        this.ID_Room = ID_Room;
        this.ID_Service = ID_Service;
        Name_Hotel = name_Hotel;
        Name_Service = name_Service;
        Price_Service = price_Service;
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

    public String getName_Hotel() {
        return Name_Hotel;
    }

    public void setName_Hotel(String name_Hotel) {
        Name_Hotel = name_Hotel;
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
