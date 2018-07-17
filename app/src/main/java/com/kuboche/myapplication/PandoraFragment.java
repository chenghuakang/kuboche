package com.kuboche.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class PandoraFragment extends Fragment {
    Button btn1;
    Button btn2;
    Button btn3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pandora, null);
        btn1 = (Button) view.findViewById(R.id.pandora_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), pandora1.class);
                startActivity(intent);
            }
        });
        btn2 = (Button) view.findViewById(R.id.pandora_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), pandora2.class);
                startActivity(intent);
            }
        });
        btn3 = (Button) view.findViewById(R.id.pandora_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), pandora3.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
