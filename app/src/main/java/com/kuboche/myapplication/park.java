package com.kuboche.myapplication;
import com.kuboche.bean.PackRecord;

import java.util.Date;

public class park {
    Date date1;
    Date date2;
    String parkName;
    String name;
    public park(){
        date1 = new Date();
    }
    public boolean start(String name,String stationName){
        parkName = stationName;
        this.name = name;
        return false;
    }
    public double end(double payPerHour){
        date2 = new Date();
        long time = date2.getTime() - date1.getTime();
        double pay = payPerHour * ((time-1)/3600000 +1);
        PackRecord p = new PackRecord();
        p.setDate(date1);
        p.setParkId(parkName);
        p.setName(name);
        p.setPayment(pay);
        try {
            p.save();
        }
        catch (Exception e){
            throw e;
        }
        return pay;
         }
}
