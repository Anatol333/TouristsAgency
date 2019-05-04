package com.tour.domain;

import com.tour.domain.embeddable.EmbCustom_Check;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Custom_Check")
@IdClass(EmbCustom_Check.class)
public class Custom_Check {

    @Id
    private Integer ID_Tour;

    @Id
    private Integer id;


    private String Custom_Date_Start;

    private String Custom_Date_End;

    private String Custom_Price;

    public Custom_Check() {
    }

    public Custom_Check(Integer ID_Tour, Integer id, String custom_Date_Start, String custom_Date_End, String custom_Price) {
        this.ID_Tour = ID_Tour;
        this.id = id;
        Custom_Date_Start = custom_Date_Start;
        Custom_Date_End = custom_Date_End;
        Custom_Price = custom_Price;
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

    public String getCustom_Date_Start() {
        return Custom_Date_Start;
    }

    public void setCustom_Date_Start(String custom_Date_Start) {
        Custom_Date_Start = custom_Date_Start;
    }

    public String getCustom_Date_End() {
        return Custom_Date_End;
    }

    public void setCustom_Date_End(String custom_Date_End) {
        Custom_Date_End = custom_Date_End;
    }

    public String getCustom_Price() {
        return Custom_Price;
    }

    public void setCustom_Price(String custom_Price) {
        Custom_Price = custom_Price;
    }
}
