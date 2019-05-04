package com.tour.domain.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmbCustom_Check implements Serializable {

    private Integer ID_Tour;

    private Integer id;

    public EmbCustom_Check(Integer ID_Tour, Integer id) {
        this.ID_Tour = ID_Tour;
        this.id = id;
    }

    public EmbCustom_Check() {
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
