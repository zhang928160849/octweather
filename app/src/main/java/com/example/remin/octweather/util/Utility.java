package com.example.remin.octweather.util;

import android.text.TextUtils;

import com.example.remin.octweather.db.City;
import com.example.remin.octweather.db.County;
import com.example.remin.octweather.db.Province;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by remin.
 * Created Time 2017/7/11 ${Time}
 */

public class Utility {
//   解析和处理服务器返回的省级数据
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
         try{
             JSONArray allProvinces = new JSONArray(response);
             for(int i = 0;i<allProvinces.length();i++){
                 JSONObject provinceObject = allProvinces.getJSONObject(i);
                 Province province = new Province();
                 province.setProvinceName(provinceObject.getString("name"));
                 province.setProvinceCode(provinceObject.getInt("id"));
                 province.save();
             }
             return true;
         }catch (Exception e){
             e.printStackTrace();
         }
        }
        return false;
    }
//    解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
               JSONArray allCities = new JSONArray(response);
                for(int i =0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceID(provinceId);
                    city.save();
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }


//    解析和处理服务器返回的县级数据
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject jsonObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCityId(cityId);
                    county.setCountyName(jsonObject.getString("name"));
                    county.setWeatherId(jsonObject.getString("weather_id"));
                    county.save();
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
