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
        Parkinfo information = new Parkinfo("华大停车场", "洪山区珞喻路152号", 3, true, 114.3678, 30.5076, "18171370371");
        information.save();
        information = new Parkinfo("南湖停车场", "南湖路2号", 5, true, 114.3566, 30.4999, "18171372219");
        information.save();
        information = new Parkinfo("东湖景区停车场", "鲁磨路236号", 10, false, 114.3328, 30.5520, "18171370371");
        information.save();
        information = new Parkinfo("光谷停车场", "光谷步行街", 5, false, 114.3746, 30.5534, "15071281336");
        information.save();
        information = new Parkinfo("创意城停车场", "街道口银泰创意城", 5, true, 114.3668, 30.5099, "15071281336");
        information.save();
        information = new Parkinfo("省图书馆停车场", "武昌区公正路25号", 5, true, 114.3578, 30.4876, "15071281336");
        information.save();
        information = new Parkinfo("楚河汉街停车场", "武汉市武昌区公正路", 5, true, 114.3523, 30.4834, "15071281336");
        information.save();
        information = new Parkinfo("武汉大学信息学部停车场", "洪山区珞喻路129号", 3, true, 114.3656, 30.5677, "15071281336");
        information.save();
        information = new Parkinfo("武汉理工大学马房山校区停车场", "洪山区珞狮路205号", 3, true, 114.3638, 30.5624, "15071281336");
        information.save();
        information = new Parkinfo("华中农业大学停车场", "洪山区狮子山街1号", 3, true, 114.3642, 30.5629, "15071281336");
        information.save();
        information = new Parkinfo("华中科技大学停车场", "洪山区珞喻路1037号", 3, true, 114.3654, 30.5632, "15071281336");
        information.save();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data2);
        main();
        List<Parkinfo> parkS = Parkinfo.listAll(Parkinfo.class);
        List<Parkinfo> parkDes1 = new ArrayList<Parkinfo>();
        List<Parkinfo> parkDes = new ArrayList<Parkinfo>();
        for (int i = 0; i < parkS.size(); i++) {
            Boolean flagK = parkS.get(i).getEmpty();
            if (flagK == true)
                parkDes1.add(parkS.get(i));
        }
        //aboutme3 a = new aboutme3();
        //a.locate();
        double desX = 114.3644;
        double desY = 30.5534;//传进来的位置
        //搜索相关地理位置，扔进新的列表中
        for (int i = 0; i < parkDes1.size(); i++) {
            if (calculateDistance.main(desX, desY, parkDes1.get(i).getX(), parkDes1.get(i).getY()) <= 5000) {
                parkDes.add(parkDes1.get(i));
            }
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
        /*Parkinfo p = PackRecord.findById(Parkinfo.class, (int) (l + 1));
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
        }*/

        Parkinfo p = PackRecord.findById(Parkinfo.class, (int) (l + 1));
        String parkinfo = "名字："+ p.getParkname() +"\n位置："+p.getPosition()+"\n收费标准："+p.getCharge()+"元/小时"+"\n联系方式："+p.getPhonenum();
        Bundle bundle = new Bundle();
        bundle.putString("parkinfo",parkinfo);
        bundle.putString("name",p.getParkname());
        bundle.putString("phonenum",p.getPhonenum());
        bundle.putFloat("price",p.getCharge());
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(data2.this, data3.class);
        startActivity(intent);

    }

}
