package com.kuboche.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kuboche.bean.User;

import java.util.List;

import static com.kuboche.myapplication.R.id.*;
import static com.orm.util.ContextUtil.getSharedPreferences;

public class aboutmeFragment extends Fragment {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutme, null);
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String account = preferences.getString("data", "defaultname");
        List<User> userList = User.find(User.class, "account=?", account);
        String nickname=userList.get(0).getNickname();
        TextView textView1 = (TextView) view.findViewById(tv1);
        textView1.setText(nickname+"\n"+account);



        //List<User> us = User.listAll(User.class);
        btn1 = (Button) view.findViewById(aboutme_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), aboutme1.class);
                startActivity(intent);
            }
        });
        btn2 = (Button) view.findViewById(aboutme_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), aboutme2.class);
                startActivity(intent);
            }
        });
        btn3 = (Button) view.findViewById(aboutme_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), map.class);
                startActivity(intent);
            }
        });
        btn4 = (Button) view.findViewById(aboutme_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClassName(getActivity(), "com.kuboche.myapplication.change_password2_1");
                startActivity(intent2);
            }
        });
        btn5 = (Button) view.findViewById(aboutme_btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClassName(getActivity(), "com.kuboche.myapplication.start");
                startActivity(intent2);
            }
        });
        return view;
    }
}