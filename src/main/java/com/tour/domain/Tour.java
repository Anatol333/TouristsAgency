package com.tour.domain;

import javax.persistence.*;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_Tour;

    @Column(name = "Total_Price")
    private Integer price;

    private String Date_Start;

    private String Date_End;

    private String Header_Name;

    private String Description;

    private String Photo;

    public Tour() {
    }

    public Tour(Integer price, String date_Start, String date_End,
                String header_Name, String description, String photo) {
        this.price = price;
        Date_Start = date_Start;
        Date_End = date_End;
        Header_Name = header_Name;
        Description = description;
        Photo = photo;
    }

    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate_Start() {
        return Date_Start;
    }

    public void setDate_Start(String date_Start) {
        Date_Start = date_Start;
    }

    public String getDate_End() {
        return Date_End;
    }

    public void setDate_End(String date_End) {
        Date_End = date_End;
    }

    public String getHeader_Name() {
        return Header_Name;
    }

    public void setHeader_Name(String header_Name) {
        Header_Name = header_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }
}
