package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.time.Instant;

public class change_password1 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password1);
    }
    public void password2(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.change_password2");
        startActivity(i);
    }

}
