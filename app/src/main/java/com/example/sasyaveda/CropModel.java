package com.example.sasyaveda;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

public class CropModel {

    String arrival_date,commodity,district,market,state,variety,timestamp;
    String max_price,min_price,modal_price;


    public CropModel(){}
    public CropModel(String arrival_date, String commodity, String district, String market, String state, String variety, String timestamp, String max_price, String min_price, String modal_price) {
        this.arrival_date = arrival_date;
        this.commodity = commodity;
        this.district = district;
        this.market = market;
        this.state = state;
        this.variety = variety;
        this.timestamp = timestamp;
        this.max_price = max_price;
        this.min_price = min_price;
        this.modal_price = modal_price;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getModal_price() {
        return modal_price;
    }

    public void setModal_price(String modal_price) {
        this.modal_price = modal_price;
    }

    public String getTimestamp() {
        Calendar cal=Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(Long.parseLong(timestamp));
        String date = DateFormat.format("dd-MM-yyyy hh:mm:ss", cal).toString();
        return date;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
