package com.kuboche.bean;

import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;

@Table
public class Parkinfo extends SugarRecord implements Serializable {
    private String parkname;
    private String position;
    private long charge;
    private Boolean empty;
    private double x;
    private double y;
    private String phonenum;

    public Parkinfo(String parkname, String position, long charge, Boolean empty, double x, double y, String phonenum) {
        this.parkname = parkname;
        this.position = position;
        this.charge = charge;
        this.empty = empty;
        this.x = x;
        this.y = y;
        this.phonenum = phonenum;
    }

    public Parkinfo() {
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}

