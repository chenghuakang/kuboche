package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.kuboche.bean.PackRecord;

import java.util.Date;

public class park extends Activity {
    Date date1;
    Date date2;
    String parkName;
    String name;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.park);
    }

    public park() {
        date1 = new Date();
    }

    public boolean start(View v) {
        name = "康程华";
        parkName = "马路上";
        message = name + "要在" + parkName + "停车场停车";
        Uri uri = Uri.parse("smsto:" + "10086");
        Intent in = new Intent(Intent.ACTION_VIEW, uri);
        in.putExtra("sms_body", message);
//        intent.setType("rnd");
        startActivity(in);
        return false;
    }

    public double end(double payPerHour) {
        date2 = new Date();
        long time = date2.getTime() - date1.getTime();
        double pay = payPerHour * ((time - 1) / 3600000 + 1);
        PackRecord p = new PackRecord();
        p.setDate(date1);
        p.setParkId(parkName);
        p.setName(name);
        p.setPayment(pay);
        try {
            p.save();
        } catch (Exception e) {
            throw e;
        }
        return pay;
    }
}
