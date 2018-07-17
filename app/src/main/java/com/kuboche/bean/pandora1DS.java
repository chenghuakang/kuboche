package com.kuboche.bean;


import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;

@Table
public class pandora1DS extends SugarRecord implements Serializable {
    private String location;//车位位置
    private float price;//车位价格
    private String contactPerson;//联系人
    private String contactWay;//联系方式
    private String introduction;//简介

    public pandora1DS() {
    }

    ;

    public pandora1DS(String location, float price, String contactWay, String contactPerson, String introduction) {
        this.location = location;
        this.price = price;
        this.contactWay = contactWay;
        this.contactPerson = contactPerson;
        this.introduction = introduction;
    }


    public float getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactWay() {
        return contactWay;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}