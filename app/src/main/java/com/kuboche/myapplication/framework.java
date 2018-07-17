package com.kuboche.myapplication;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.kuboche.bean.PackRecord;
import com.kuboche.bean.User;

import java.util.Date;
import java.util.List;


public class framework extends AppCompatActivity {
    PandoraFragment f1;
    data1 f2;
    aboutmeFragment f3;
    Button b1;
    Button b2;
    Button b3;
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b1 = (Button) findViewById(R.id.fragment1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framework);
        loan(b1);
    }

    public void pandora(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (f1 == null) {
            f1 = new PandoraFragment();
            transaction.add(R.id.frame, f1);
        }
        hideFragment(transaction);
        transaction.show(f1);
        transaction.commit();
    }

    public void loan(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (f2 == null) {
            f2 = new data1();
            transaction.add(R.id.frame, f2);
        }
        hideFragment(transaction);
        transaction.show(f2);
        transaction.commit();
    }

    public void about_me(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (f3 == null) {
            f3 = new aboutmeFragment();
            transaction.add(R.id.frame, f3);
        }
        hideFragment(transaction);
        transaction.show(f3);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }
        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }
    }

}


