package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class change_password2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password2);
    }
    public void password3(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
        startActivity(i);
    }
}
