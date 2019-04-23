package com.tour.domain;

import javax.persistence.*;

@Entity
@Table(name = "Room_Type")
public class Room_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Room_Type;

    private String Name_Type;

    private Integer Price;

    public Room_Type() {
    }

    public Room_Type(String name_Type, Integer price) {
        Name_Type = name_Type;
        Price = price;
    }

    public Integer getID_Room_Type() {
        return ID_Room_Type;
    }

    public void setID_Room_Type(Integer ID_Room_Type) {
        this.ID_Room_Type = ID_Room_Type;
    }

    public String getName_Type() {
        return Name_Type;
    }

    public void setName_Type(String name_Type) {
        Name_Type = name_Type;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }
}
