package com.tour.domain.dto;

public class RoomHotelDTO {

    private Integer ID_Room;

    private Integer ID_Hotel;

    public RoomHotelDTO(Integer ID_Room, Integer ID_Hotel) {
        this.ID_Room = ID_Room;
        this.ID_Hotel = ID_Hotel;
    }


    public Integer getID_Room() {
        return ID_Room;
    }

    public void setID_Room(Integer ID_Room) {
        this.ID_Room = ID_Room;
    }

    public Integer getID_Hotel() {
        return ID_Hotel;
    }

    public void setID_Hotel(Integer ID_Hotel) {
        this.ID_Hotel = ID_Hotel;
    }
}
