package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kuboche.bean.PackRecord;
import com.kuboche.bean.Parkinfo;
import com.kuboche.bean.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class data2 extends Activity implements AdapterView.OnItemClickListener {
    ListView listView;

    public void main() {
        Parkinfo information = new Parkinfo("华大停车场", "洪山区珞喻路152号", 3, true,114.12,30.335,"18171370371");
        information.save();
        information = new Parkinfo("南湖停车场", "南湖路2号", 5, true,114.12,81.34,"18171372219");
        information.save();
        information = new Parkinfo("东湖景区停车场", "鲁磨路236号", 10, false,114,82,"18171370371");
        information.save();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data2);
        main();
        List<Parkinfo> parkS = Parkinfo.listAll(Parkinfo.class);
        List<Parkinfo> parkDes = new ArrayList<Parkinfo>();
        for (int i = 0; i < parkS.size(); i++) {
            Boolean flagK = parkS.get(i).getEmpty();
            if (flagK = true)
                parkDes.add(parkS.get(i));
        }

        String[] printinfo = new String[parkDes.size()];
        for (int i = 0; i < parkDes.size(); i++) {
            printinfo[i] = parkDes.get(i).getParkname() + "\n停车场位置：" + parkDes.get(i).getPosition() + "\n收费标准：" + parkDes.get(i).getCharge() + "元/小时";
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, printinfo);
        listView = (ListView) findViewById(R.id.information);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Parkinfo p = PackRecord.findById(Parkinfo.class, (int) (l + 1));
        List<User> us = User.listAll(User.class);
        if (!us.isEmpty()) {
            User us1 = us.get(0);
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + p.getPhonenum()));
            //sendIntent.setPackage("com.android.mms");
            sendIntent.putExtra("sms_body", us1.getAccount() + "要在" + p.getParkname() + "停车" + ",每小时" + p.getCharge() + "元");
            startActivity(sendIntent);
        } else {
            Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + p.getPhonenum()));
            //sendIntent.setPackage("com.android.mms");
            sendIntent.putExtra("sms_body", "匿名人" + "要在" + p.getParkname() + "停车" + ",每小时" + p.getCharge() + "元");
            startActivity(sendIntent);
        }

    }

}
