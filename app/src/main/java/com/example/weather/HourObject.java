package com.example.weather;

public class HourObject extends Object {
    private int hour;

    public HourObject(int img, String temperature, int hour) {
        super(img, temperature);
        this.hour = hour;
    }


    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }
}
