package com.tour.domain;

import com.tour.domain.embeddable.EmbRoom;

import javax.persistence.*;

@Entity
@Table(name = "Room")
@IdClass(EmbRoom.class)
public class Room {

    @Id
    private Integer ID_Room;

    @Id
    private Integer ID_Hotel;

    private Integer ID_Room_Type;

    private Integer Room_Price;

    public Room() {
    }

    public Room(Integer ID_Hotel, Integer ID_Room_Type, Integer room_Price) {
        this.ID_Hotel = ID_Hotel;
        this.ID_Room_Type = ID_Room_Type;
        Room_Price = room_Price;
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

    public Integer getID_Room_Type() {
        return ID_Room_Type;
    }

    public void setID_Room_Type(Integer ID_Room_Type) {
        this.ID_Room_Type = ID_Room_Type;
    }

    public Integer getRoom_Price() {
        return Room_Price;
    }

    public void setRoom_Price(Integer room_Price) {
        Room_Price = room_Price;
    }
}
