package com.kuboche.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class framework extends AppCompatActivity{
    PandoraFragment f1;
    data1 f2;
    test f3;
    Button b1;
    Button b2;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b1=(Button)findViewById(R.id.fragment1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framework);
        loan(b1);
    }
    public void pandora(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(f1 == null) {
            f1 = new PandoraFragment();
            transaction.add(R.id.frame, f1);
        }
        hideFragment(transaction);
        transaction.show(f1);
        transaction.commit();
    }
    public void loan(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(f2 == null) {
            f2 = new data1();
            transaction.add(R.id.frame, f2);
        }
        hideFragment(transaction);
        transaction.show(f2);
        transaction.commit();
    }
    public void about_me(View v){
        Intent i =new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.aboutme");
        startActivity(i);
    }

    private void hideFragment(FragmentTransaction transaction){
        if(f1 != null){
            transaction.hide(f1);
        }
        if(f2 != null){
            transaction.hide(f2);
        }
        if(f3 != null){
            transaction.hide(f3);
        }
    }
}


