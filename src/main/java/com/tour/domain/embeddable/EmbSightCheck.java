package com.tour.domain.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmbSightCheck implements Serializable {

    private Integer ID_Sight;

    private Integer ID_Tour;

    private Integer id;

    public EmbSightCheck() {
    }

    public EmbSightCheck(Integer ID_Sight, Integer ID_Tour, Integer id) {
        this.ID_Sight = ID_Sight;
        this.ID_Tour = ID_Tour;
        this.id = id;
    }

    public Integer getID_Sight() {
        return ID_Sight;
    }

    public void setID_Sight(Integer ID_Sight) {
        this.ID_Sight = ID_Sight;
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
