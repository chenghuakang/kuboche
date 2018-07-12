package com.kuboche.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class data2 extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data2);
        ArrayList<HashMap<String, Object>> users = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 10; i++){
            HashMap<String, Object> user = new HashMap<String, Object>();
            user.put("parkname","停车场（"+ i +"）");
            user.put("parkinfo","距离："+ (300+i) + "m");
            users.add(user);
        }
        SimpleAdapter saImageItems = new SimpleAdapter(this, users, R.layout.listview_item, new String[]{"parkname","parkinfo"}, new int[]{R.id.parkname, R.id.parkinfo});
        ((ListView)findViewById(R.id.users)).setAdapter(saImageItems);
    }
}
