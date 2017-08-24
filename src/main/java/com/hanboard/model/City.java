package com.hanboard.model;

import java.io.Serializable;

/**
 * Created by csj on 2017/8/18.
 */
public class City  implements Serializable{

    private  String id;
    private  String cityName;
    private  String cityNum;


    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityNum='" + cityNum + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNum() {
        return cityNum;
    }

    public void setCityNum(String cityNum) {
        this.cityNum = cityNum;
    }
}
