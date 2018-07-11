package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        if(passwordIsRight("password","password1")) {
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
        startActivity(i);
        /*setContentView(R.layout.framework);*/
        }
        else{
            Toast.makeText(this,"密码错误",Toast.LENGTH_LONG).show();
        }
    }
    public void signIn(View v){
        Intent i =new Intent();
        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.signin");
        startActivity(i);
    }
    public void password1(View v){
        Intent i =new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.change_password1");
        startActivity(i);
    }
    private boolean passwordIsRight(String password1,String password2){
        return password1.equals(password2);
    }
}
