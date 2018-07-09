package com.kuboche.bean;

import com.orm.SugarRecord;
import com.orm.annotation.Table;

import java.io.Serializable;
import java.util.Date;

@Table
public class PackRecord extends SugarRecord implements Serializable {
    private String name;
    private Date date;
    private int parkId;
    private Double payment;

    public PackRecord(){}
    public PackRecord(int parkId,String name,Double payment,Date date){
        this.date = date;
        this.name = name;
        this.parkId = parkId;
        this.payment = payment;
    }
    public Date getDate() {
        return date;
    }


    public int getParkId() {
        return parkId;
    }

    public Double getPayment() {
        return payment;
    }

    public String getName() {
        return name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

}
