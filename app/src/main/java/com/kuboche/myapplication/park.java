package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kuboche.bean.PackRecord;

import java.util.Date;

public class park extends Fragment {
    Date date1;
    Date date2;
    String parkName;
    String name;
    String message;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.park, null);
        Button btn = (Button) view.findViewById(R.id.endPark);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            end();
            if(getActivity() instanceof parkable){
                ((parkable)getActivity()).parkCallBack();
            }
            }
        });
        return view;
    }

    public park() {
        date1 = new Date();
    }

    public boolean start() {
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

    public double end() {
        date2 = new Date();
        long time = date2.getTime() - date1.getTime();
        double payPerHour;
        payPerHour =PackRecord.findById(PackRecord.class,1).getPayment();
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
    public interface parkable{
        void parkCallBack();
    }
}
