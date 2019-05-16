package com.tour.domain.dto;

public class AccountUserTour {

    private String Header_Name;

    private String Custom_Date_Start;

    private String Custom_Date_End;

    private String Custom_Price;

    private Integer ID_Tour;

    public AccountUserTour() {
    }

    public AccountUserTour(String header_Name,
                           String custom_Date_Start,
                           String custom_Date_End,
                           String custom_Price,
                           Integer ID_Tour) {
        Header_Name = header_Name;
        Custom_Date_Start = custom_Date_Start;
        Custom_Date_End = custom_Date_End;
        Custom_Price = custom_Price;
        this.ID_Tour = ID_Tour;
    }

    public String getHeader_Name() {
        return Header_Name;
    }

    public void setHeader_Name(String header_Name) {
        Header_Name = header_Name;
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

    public Integer getID_Tour() {
        return ID_Tour;
    }

    public void setID_Tour(Integer ID_Tour) {
        this.ID_Tour = ID_Tour;
    }
}
