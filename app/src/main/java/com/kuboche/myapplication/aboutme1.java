package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.kuboche.bean.User;

import java.util.List;

import static com.orm.util.ContextUtil.getSharedPreferences;

public class aboutme1 extends Activity {
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutme1);

        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String account = preferences.getString("data", "defaultname");
        List<User> userList = User.find(User.class, "account=?", account);
        //List<User> us = User.listAll(User.class);
        if (!userList.isEmpty()) {
            User us1 = userList.get(0);
            String[] strs1 = {"账号： " + us1.getAccount(), "用户组：普通"};
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_expandable_list_item_1, strs1);
            listView = (ListView) findViewById(R.id.aboutmelist1);
            listView.setAdapter(adapter1);
        } else {
            Toast.makeText(this, "账号不存在", Toast.LENGTH_LONG).show();
        }
    }
}
