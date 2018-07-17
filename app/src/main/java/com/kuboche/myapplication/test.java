package com.kuboche.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class test extends Fragment {
    String name;

    public test(String fName) {
        this.name = fName;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if (name == "pandora") {
            view = inflater.inflate(R.layout.pandora, container, false);
        } else
            view = inflater.inflate(R.layout.pandora, container, false);
        return view;
    }

}
