package com.example.remin.octweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by remin.
 * Created Time 2017/7/11 ${Time}
 */

public class City extends DataSupport {
    private int id;
    private String cityName;
    private int cityCode;
    private int provinceID;

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getProvinceID() {
        return provinceID;
    }
}
