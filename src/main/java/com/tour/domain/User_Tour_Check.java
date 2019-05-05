package com.tour.domain;


import com.tour.domain.embeddable.EmbCustom_Check;
import com.tour.domain.embeddable.EmbMiddleCheck;

import javax.persistence.*;

@Entity
@Table(name = "User_Tour_Check")
@IdClass(EmbMiddleCheck.class)
public class User_Tour_Check {

    @Id
    private Integer ID_Custom_Tour_List;

    private Integer ID_Room;

    private Integer ID_Service;

    private Integer ID_Hotel;

    @Id
    private Integer ID_Tour;

    @Id
    private Integer id;

    public User_Tour_Check(Integer ID_Custom_Tour_List, Integer ID_Room, Integer ID_Service, Integer ID_Hotel, Integer ID_Tour, Integer id) {
        this.ID_Custom_Tour_List = ID_Custom_Tour_List;
        this.ID_Room = ID_Room;
        this.ID_Service = ID_Service;
        this.ID_Hotel = ID_Hotel;
        this.ID_Tour = ID_Tour;
        this.id = id;
    }

    public User_Tour_Check() {
    }


    public Integer getID_Custom_Tour_List() {
        return ID_Custom_Tour_List;
    }

    public void setID_Custom_Tour_List(Integer ID_Custom_Tour_List) {
        this.ID_Custom_Tour_List = ID_Custom_Tour_List;
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

    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
