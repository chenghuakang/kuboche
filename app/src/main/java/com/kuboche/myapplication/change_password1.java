package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kuboche.bean.User;

import java.time.Instant;
import java.util.List;

public class change_password1 extends Activity {

    String account1;
    String account;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password1);
    }
    public void password2(View v){
        EditText editText1 = (EditText) findViewById(R.id.account1);
        account1 = editText1.getText().toString();
        //显示用户的密保问题并显示
        List<User> userList= User.find(User.class,"account=?",account1);
        String securityQuestion=userList.get(0).getSecurityQuestion().toString();
        if(securityQuestion == null){
            Toast.makeText(this, R.string.toast1, Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.setClassName(getApplicationContext(), "com.kuboche.myapplication.signin");
            startActivity(i);
        }
        else{
            setContentView(R.layout.change_password2);
            TextView textView = (TextView) findViewById(R.id.securityQuestion);
            textView.setText(securityQuestion);
        }
    }
    public void password3(View v){
        setContentView(R.layout.change_password3);
    }
    public void password4(View v){
        EditText editText1 = (EditText) findViewById(R.id.password1);
        account = editText1.getText().toString();
        //获取输入的密码
        EditText editText2 = (EditText) findViewById(R.id.password2);
        String pwd1 = editText2.getText().toString();
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
        startActivity(i);
    }

}
