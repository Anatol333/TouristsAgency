package com.tour.domain;

import com.tour.domain.embeddable.EmbCustom_Check;
import com.tour.domain.embeddable.EmbCustom_City_List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Custom_City_List")
@IdClass(EmbCustom_City_List.class)
public class Custom_City_List {

    @Id
    private Integer ID_Custom_Tour_List;

    @Id
    private Integer ID_City_Tour;

    @Id
    private Integer ID_Tour;

    @Id
    private Integer id;

    public Custom_City_List() {
    }

    public Custom_City_List(Integer ID_Custom_Tour_List, Integer ID_City_Tour, Integer ID_Tour, Integer id) {
        this.ID_Custom_Tour_List = ID_Custom_Tour_List;
        this.ID_City_Tour = ID_City_Tour;
        this.ID_Tour = ID_Tour;
        this.id = id;
    }


    public Integer getID_Custom_Tour_List() {
        return ID_Custom_Tour_List;
    }

    public void setID_Custom_Tour_List(Integer ID_Custom_Tour_List) {
        this.ID_Custom_Tour_List = ID_Custom_Tour_List;
    }

    public Integer getID_City_Tour() {
        return ID_City_Tour;
    }

    public void setID_City_Tour(Integer ID_City_Tour) {
        this.ID_City_Tour = ID_City_Tour;
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
