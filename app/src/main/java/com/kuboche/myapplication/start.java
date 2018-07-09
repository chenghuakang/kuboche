package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.time.Instant;

public class start extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void logIn(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
        startActivity(i);
        /*setContentView(R.layout.framework);*/
    }
    public void signIn(View v){
        Intent i =new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.signin");
        startActivity(i);
    }
    public void password1(View v){
        Intent i =new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.change_password1");
        startActivity(i);
    }

}
