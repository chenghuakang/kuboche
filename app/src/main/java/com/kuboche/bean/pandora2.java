package com.kuboche.bean;


import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;

@Table
public class pandora2 extends SugarRecord implements Serializable {
    private String name; //汽车服务中心的名字
    private String location;//位置
    private float averageCost;//人均消费
    private String contactWay;//联系方式
    private String contactPerson;//联系人

    public pandora2(){}
    public pandora2(String name,String location,float averageCost,String contactPerson,String contactWay) {
        this.name = name;
        this.location = location;
        this.averageCost = averageCost;
        this.contactPerson = contactPerson;
        this.contactWay = contactWay;
    }

    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public String getContactWay() {
        return contactWay;
    }

    public String getContactPerson() {
        return contactPerson;
    }
    public float getAverageCost() {
        return averageCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public void setAverageCost(float averageCost) {
        this.averageCost = averageCost;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}