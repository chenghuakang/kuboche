package com.kuboche.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kuboche.bean.PackRecord;

import java.util.Date;
import java.util.List;

public class aboutme2 extends Activity {
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutme2);

        PackRecord p = new PackRecord("49", "njnsajdk", 6.646, new Date());
        p.save();
        p = new PackRecord("55", "FASHUIk", 8.136, new Date());
        p.save();
        p = new PackRecord("79", "FASHUIk", 8.136, new Date());
        p.save();
        p = new PackRecord("321", "FASHUIk", 8.136, new Date());
        p.save();
        List<PackRecord> p2 = PackRecord.listAll(PackRecord.class);
        String[] strs2 = new String[p2.size()];
        for (int j = 0; j < p2.size(); j++) {
            strs2[j] = "No" + j + "    " + p2.get(j).getName() + "  " + p2.get(j).getParkId()
                    + "号停车场\n" + p2.get(j).getDate().toString();
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, strs2);
        listView = (ListView) findViewById(R.id.aboutmelist2);
        listView.setAdapter(adapter2);
    }
}
