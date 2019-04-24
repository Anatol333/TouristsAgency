package com.tour.domain;

import com.tour.domain.embeddable.EmbRoom_Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Room_Service")
@IdClass(EmbRoom_Service.class)
public class Room_Service {

    @Id
    private Integer ID_Room;

    @Id
    private Integer ID_Service;

    @Id
    private Integer ID_Hotel;

    public Room_Service() {
    }

    public Room_Service(Integer ID_Room, Integer ID_Service, Integer ID_Hotel) {
        this.ID_Room = ID_Room;
        this.ID_Service = ID_Service;
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

    public Integer getID_Hotel() {
        return ID_Hotel;
    }

    public void setID_Hotel(Integer ID_Hotel) {
        this.ID_Hotel = ID_Hotel;
    }
}
