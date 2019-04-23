package com.tour.domain.embeddable;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class EmbTour_Content implements Serializable {

    private Integer ID_City;
    private Integer ID_Tour;

    public EmbTour_Content() {
    }

    public EmbTour_Content(Integer ID_City, Integer ID_Tour) {
        this.ID_City = ID_City;
        this.ID_Tour = ID_Tour;
    }

    public Integer getID_City() {
        return ID_City;
    }

    public void setID_City(Integer ID_City) {
        this.ID_City = ID_City;
    }

    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }
}
