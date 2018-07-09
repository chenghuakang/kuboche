package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class signin extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
    }
    public void signin1(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
        startActivity(i);
    }
    public void quit1(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.start");
        startActivity(i);
    }
}
