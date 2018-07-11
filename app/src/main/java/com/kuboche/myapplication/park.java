package com.kuboche.myapplication;

import android.widget.Toast;

import com.kuboche.bean.PackRecord;

import java.util.Date;

public class park {
    Date date1;
    Date date2;
    public park(){
        date1 = new Date();
    }
    public boolean start(String name,String stationName){
        try{
            PackRecord p = new PackRecord();

        }
        catch (ArithmeticException e){
            throw e;
        }
        return false;
    }
    public double end(double payPerHour){
        date2 = new Date();
        long time = date2.getTime() - date1.getTime();
        return payPerHour * ((time-1)/3600000 +1);
         }
}
