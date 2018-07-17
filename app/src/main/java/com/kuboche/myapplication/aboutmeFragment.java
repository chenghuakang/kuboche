package com.kuboche.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class aboutmeFragment extends Fragment {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aboutme, null);
        btn1 = (Button) view.findViewById(R.id.aboutme_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), aboutme1.class);
                startActivity(intent);
            }
        });
        btn2 = (Button) view.findViewById(R.id.aboutme_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), aboutme2.class);
                startActivity(intent);
            }
        });
        btn3 = (Button) view.findViewById(R.id.aboutme_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), aboutme3.class);
                startActivity(intent);
            }
        });
        btn4 = (Button) view.findViewById(R.id.aboutme_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
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