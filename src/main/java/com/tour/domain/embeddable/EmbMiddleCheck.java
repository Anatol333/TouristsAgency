package com.tour.domain.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmbMiddleCheck implements Serializable {

    private Integer ID_Custom_Tour_List;

    private Integer ID_Tour;

    private Integer id;

    public EmbMiddleCheck(Integer ID_Custom_Tour_List, Integer ID_Tour, Integer id) {
        this.ID_Custom_Tour_List = ID_Custom_Tour_List;
        this.ID_Tour = ID_Tour;
        this.id = id;
    }

    public EmbMiddleCheck() {
    }

    public Integer getID_Custom_Tour_List() {
        return ID_Custom_Tour_List;
    }

    public void setID_Custom_Tour_List(Integer ID_Custom_Tour_List) {
        this.ID_Custom_Tour_List = ID_Custom_Tour_List;
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
