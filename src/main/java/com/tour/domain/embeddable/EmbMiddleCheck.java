package com.tour.domain.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmbMiddleCheck implements Serializable {

    private Integer ID_Tour;

    private Integer id;

    private Integer ID_Room;

    private Integer ID_Service;

    private Integer ID_Hotel;


    public EmbMiddleCheck(Integer ID_Tour, Integer id, Integer ID_Room, Integer ID_Service, Integer ID_Hotel) {
        this.ID_Tour = ID_Tour;
        this.id = id;
        this.ID_Room = ID_Room;
        this.ID_Service = ID_Service;
        this.ID_Hotel = ID_Hotel;
    }

    public EmbMiddleCheck() {
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
