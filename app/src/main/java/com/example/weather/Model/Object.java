package com.example.weather.Model;

public class Object {
    protected String temperature;
    protected int img;

    public Object(int img, String temperature) {
        this.temperature = temperature;
        this.img = img;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTemperature() {
        return temperature;
    }

    public int getImg() {
        return img;
    }
}
