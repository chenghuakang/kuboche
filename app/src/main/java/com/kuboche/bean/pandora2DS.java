package com.kuboche.bean;


import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;

@Table
public class pandora2DS extends SugarRecord implements Serializable {
    private String name; //汽车服务中心的名字
    private String location;//位置
    private double averageCost;//人均消费
    private String contactWay;//联系方式
    private String contactPerson;//联系人
    private double x;
    private double y;

    public pandora2DS() {
    }

    public pandora2DS(String name, String location, double averageCost, String contactWay, double x, double y) {
        this.name = name;
        this.location = location;
        this.averageCost = averageCost;
        this.contactWay = contactWay;
        this.x = x;
        this.y = y;
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

    public String getAverageCost() {
        return "" + averageCost;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}