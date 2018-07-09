package com.kuboche.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;



public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   //隐藏状态栏
        getSupportActionBar().hide();   //隐藏标题栏
        setContentView(R.layout.activity_splash);
        Thread MyThread = new Thread() {   //创建子线程
            @Override
            public void run() {
                try {
                    sleep(5000); //使程序休眠五秒
                    Intent it = new Intent(getApplicationContext(), start.class);
                    startActivity(it);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        MyThread.start();
    }

}

