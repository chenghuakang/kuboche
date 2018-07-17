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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class change_password1 extends Activity {

    String account1;
    String account;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password1);
    }

    public void password2(View v) {
        EditText editText1 = (EditText) findViewById(R.id.account1);
        account1 = editText1.getText().toString();
        //获取用户的密保问题并显示
        List<User> userList = User.find(User.class, "account=?", account1);
        if (userList.size() == 0) {
            Toast.makeText(this, "手机号不正确！", Toast.LENGTH_LONG).show();
            //setContentView(R.layout.change_password1);
        } else {
            String securityQuestion = userList.get(0).getSecurityQuestion().toString();
        /*
        if(securityQuestion == null){
            Toast.makeText(this, R.string.toast1, Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.setClassName(getApplicationContext(), "com.kuboche.myapplication.signin");
            startActivity(i);
        }    */
            setContentView(R.layout.change_password2);
            TextView textView = (TextView) findViewById(R.id.securityQuestion);
            textView.setText(securityQuestion);
        }
    }

    public void password3(View v) {

        //获取用户输入的账号
        EditText editText2 = (EditText) findViewById(R.id.securityAnswer1);
        String securityAnswer1;
        securityAnswer1 = editText2.getText().toString();
        //取出用户存在数据库里的密保答案
        List<User> userList = User.find(User.class, "account=?", account1);
        String securityAnswer = userList.get(0).getSecurityAnswer().toString();
        //验证答案是否正确
        if (securityAnswer.equals(securityAnswer1)) {
            setContentView(R.layout.change_password3);
        } else Toast.makeText(this, "答案不正确！", Toast.LENGTH_LONG).show();
    }


    public void password4(View v) {
        //获取输入的密码
        EditText editText1 = (EditText) findViewById(R.id.password1);
        String password1 = editText1.getText().toString();
        //获取确认的密码
        EditText editText2 = (EditText) findViewById(R.id.password2);
        String password2 = editText2.getText().toString();
        Pattern p2 = Pattern.compile(".{6,10}");
        Matcher m2 = p2.matcher(password1);
        if (password1.equals("")) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_LONG).show();
        } else if (password2.equals("")) {
            Toast.makeText(this, "请确认密码！", Toast.LENGTH_LONG).show();
        } else if (password1.equals(password2)) {
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
        } else Toast.makeText(this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();

    }


}



