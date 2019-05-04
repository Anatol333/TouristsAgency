package com.tour.domain.dto;

public class RoomDTO {

    private Integer ID_Room;

    private Integer ID_Service;

    private String Name_Service;

    public RoomDTO() {
    }

    public RoomDTO(Integer ID_Room, Integer ID_Service, String name_Service) {
        this.ID_Room = ID_Room;
        this.ID_Service = ID_Service;
        Name_Service = name_Service;
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

    public String getName_Service() {
        return Name_Service;
    }

    public void setName_Service(String name_Service) {
        Name_Service = name_Service;
    }
}
