package com.tour.domain;

import com.tour.domain.embeddable.EmbSightCheck;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Sight_Custom_Check")
@IdClass(EmbSightCheck.class)
public class Sight_Custom_Check {

    @Id
    private Integer ID_Sight;

    @Id
    private Integer ID_Tour;

    @Id
    private Integer id;

    public Sight_Custom_Check() {
    }

    public Sight_Custom_Check(Integer ID_Sight, Integer ID_Tour, Integer id) {
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
