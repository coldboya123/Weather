package com.example.weather.Model;

import java.util.Date;

public class DateObject extends Object {
    private Date date;

    public DateObject(int img, String temperature, Date date) {
        super(img, temperature);
        this.date = date;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
