package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kuboche.bean.PackRecord;
import com.kuboche.bean.User;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class aboutme extends Activity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutme);
        //要显示的数据
        String[] strs = {"我的账户", "停车记录", "账户信息", "注销账户"};
        //创建ArrayAdapter
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, strs);
        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    public String[] add(String[] strs, String str) {
        String[] s = new String[strs.length + 1];
        int i = 0;
        for (String ax : strs) {
            s[i] = ax;
            i++;
        }
        s[i] = str;
        return s;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (listView.getAdapter().equals(adapter)) {
            PackRecord p = new PackRecord("49", "njnsajdk", 6.646, new Date());
            p.save();
            p = new PackRecord("55", "FASHUIk", 8.136, new Date());
            p.save();
            p = new PackRecord("79", "FASHUIk", 8.136, new Date());
            p.save();
            p = new PackRecord("321", "FASHUIk", 8.136, new Date());
            p.save();
            PackRecord p3 = PackRecord.findById(PackRecord.class, 1);
            List<PackRecord> p2 = PackRecord.listAll(PackRecord.class);


                switch ((int) l) {
                    case 0:
                        List<User> us = User.listAll(User.class);
                        if (!us.isEmpty()) {
                            User us1 = us.get(0);
                            String[] strs1 = {"账号： " + us1.getAccount(), "\n" + us1.getNickname()};
                            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                                    (this, android.R.layout.simple_expandable_list_item_1, strs1);
                            listView.setAdapter(adapter1);
                        } else {
                            Toast.makeText(this, "账号不存在", Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 1:
                        String[] strs2 = new String[p2.size()];
                        for (int j = 0; j < p2.size(); j++) {
                            strs2[j] = "No" + j + "    " + p2.get(j).getName() + "  " + p2.get(j).getParkId()
                                    + "号停车场\n" + p2.get(j).getDate().toString();
                        }
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                                (this, android.R.layout.simple_expandable_list_item_1, strs2);
                        listView.setAdapter(adapter2);
                        break;
                    case 2:
                        break;
                    case 3:
                        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "10086"));
                        //sendIntent.setPackage("com.android.mms");
                        sendIntent.putExtra("sms_body", "康程华要在马路上停车");
                        startActivity(sendIntent);
                        break;
                    case 4:

                        break;

                    default:
                }

            }
        }
    }

