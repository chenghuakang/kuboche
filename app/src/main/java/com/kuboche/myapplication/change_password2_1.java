package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kuboche.bean.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.orm.util.ContextUtil.getSharedPreferences;

public class change_password2_1 extends Activity {

    String account1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password2_1);

    }


    public void password5(View v){
        SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        String account=preferences.getString("data", "defaultname");
        account1=account;

        //获取用户输入的账号
        EditText editText2 = (EditText) findViewById(R.id.password1_1);
        String password1_1;
        password1_1 = editText2.getText().toString();
        //取出用户存在数据库里的密保答案
        List<User> userList= User.find(User.class,"account=?",account1);
        String  password=userList.get(0).getPassword().toString();
        //验证答案是否正确
        if( password1_1.equals( password)) {
            setContentView(R.layout.change_password2_2);
        }
        else Toast.makeText(this, "密码不正确！", Toast.LENGTH_LONG).show();
    }


    public void password6(View v){
        //获取输入的密码
        EditText editText1 = (EditText) findViewById(R.id.password2_1);
        String password1 = editText1.getText().toString();
        //获取确认的密码
        EditText editText2 = (EditText) findViewById(R.id.password2_2);
        String password2 = editText2.getText().toString();
        Pattern p2 = Pattern.compile(".{6,10}");
        Matcher m2 = p2.matcher(password1);
        if(password1.equals("")){
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_LONG).show();
        }
        else if(password2.equals("")){
            Toast.makeText(this, "请确认密码！", Toast.LENGTH_LONG).show();
        }


        else if (password1.equals(password2)) {
            if (m2.matches()) {
                List<User> userList = User.find(User.class, "account=?", account1);
                userList.get(0).setPassword(password1);
                userList.get(0).save();
                Intent i = new Intent();
                i.setClassName(getApplicationContext(), "com.kuboche.myapplication.start");
                startActivity(i);
                //setContentView(R.layout.framework);
                Toast.makeText(this, "修改密码成功！", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "密码太短或太长（6-10位）！", Toast.LENGTH_LONG).show();
            }
        }
        else Toast.makeText(this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();

    }


}
