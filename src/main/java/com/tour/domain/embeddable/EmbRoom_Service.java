package com.tour.domain.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmbRoom_Service  implements Serializable {

    private Integer ID_Room;
    private Integer ID_Service;
    private Integer ID_Hotel;

    public EmbRoom_Service() {
    }

    public EmbRoom_Service(Integer ID_Room, Integer ID_Service, Integer ID_Hotel) {
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
