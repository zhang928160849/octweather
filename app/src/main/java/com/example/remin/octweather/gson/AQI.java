package com.example.remin.octweather.gson;

/**
 * Created by remin.
 * Created Time 2017/7/16 ${Time}
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
