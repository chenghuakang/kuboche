package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kuboche.bean.User;

import java.util.List;

public class change_password2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取用户输入的账号
        EditText editText1 = (EditText) findViewById(R.id.account1);
        String account1 = editText1.getText().toString();
        //显示用户的密保问题并显示
        TextView textView = (TextView) findViewById(R.id.securityQuestion);
        List<User> userList= User.find(User.class,"account=?",account1);
        String securityQuestion=userList.get(1).getSecurityQuestion();
        textView.setText(securityQuestion);

        setContentView(R.layout.change_password2);
    }
    public void password3(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.change_password3");
        startActivity(i);
    }
}
