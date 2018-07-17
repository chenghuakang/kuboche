package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.kuboche.bean.User;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signin extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
       /* MobileAds.initialize(context,context.getString(R.string.ad_app));
        AdRequest adRequest = new AdRequest.Builder().build();
        AdView mAdView = (AdView) findViewById(R.id.login_av);
        mAdView.loadAd(adRequest);*/
    }

    public void signin1(View v) {
        Intent i = new Intent();
        //获取输入的账号
        EditText editText1 = (EditText) findViewById(R.id.account);
        String account = editText1.getText().toString();
        Pattern p1 = Pattern.compile("(13|14|15|17|18|19)[0-9]{9}");
        Matcher m1 = p1.matcher(account);

        if (m1.matches()) {   //判断密码格式是否正确
            //获取输入的密码
            EditText editText2 = (EditText) findViewById(R.id.pwd1);
            String pwd1 = editText2.getText().toString();
            //获取确认的密码
            EditText editText3 = (EditText) findViewById(R.id.pwd2);
            String pwd2 = editText3.getText().toString();
            //获取密保问题
            Spinner sp = (Spinner) findViewById(R.id.securityQuestion);
            String securityQuestion = (String) sp.getSelectedItem();
            //获取密保答案
            EditText editText4 = (EditText) findViewById(R.id.securityAnswer);
            String securityAnswer = editText4.getText().toString();


            if (accountIsExist(account) != 0) {  //判断注册的账号是否已存在
                Toast.makeText(this, "该账号已存在！", Toast.LENGTH_LONG).show();
            } else if (passwordIsRight(pwd1, pwd2)) {  //判断两次输入的密码是否一致
                Pattern p2 = Pattern.compile(".{6,10}");
                Matcher m2 = p2.matcher(pwd1);
                if (m2.matches()) {  //判断输入的密码格式是否符合
                    if (securityQuestion.equals("")) {   //判断密保问题是否已设置
                        Toast.makeText(this, "请设置密保问题！", Toast.LENGTH_LONG).show();
                    } else if (securityAnswer.equals("")) {//判断密保答案是否已设置
                        Toast.makeText(this, "请设置密保答案！", Toast.LENGTH_LONG).show();
                    } else {//信息全部填对时则注册
                        User U1 = new User(account, null, pwd1, securityQuestion, securityAnswer);
                        U1.save();
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        //String name="xixi";
                        //String age="22";
                        editor.putString("data", account);
                        //editor.putString("age", age);
                        editor.commit();
                        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.framework");
                        startActivity(i);
                        Toast.makeText(this, "注册成功！", Toast.LENGTH_LONG).show();
                    }
                } else { //密码格式不对的提示
                    Toast.makeText(this, "密码太短或太长（6-10位）！", Toast.LENGTH_LONG).show();
                }
            } else {  //两次输入密码不一致的提示
                Toast.makeText(this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
            }
        } else {  //手机号不符合格式的提示
            Toast.makeText(this, "手机号码不合法！", Toast.LENGTH_LONG).show();
        }
    }

    //“退出”按钮的跳转
    public void quit1(View v) {
        Intent i = new Intent();
        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.start");
        startActivity(i);
    }

    //判断两次密码是否一致
    private boolean passwordIsRight(String pwd1, String pwd2) {
        return pwd1.equals(pwd2);
    }

    //判断账号是否已经注册过
    private int accountIsExist(String account) {
        List<User> userList = User.find(User.class, "account=? ", account);
        return userList.size();
    }

    //英语切换
    public void changeLanguage(View v) {
        Resources r = getBaseContext().getResources();
        DisplayMetrics DM = r.getDisplayMetrics();
        Configuration config = r.getConfiguration();
        if (config.locale == Locale.ENGLISH) {
            config.locale = Locale.CHINESE;
            r.updateConfiguration(config, DM);
            Intent i = new Intent();
            i.setClassName(getApplicationContext(), "com.kuboche.myapplication.start");
            startActivity(i);
        } else {
            config.locale = Locale.ENGLISH;
            r.updateConfiguration(config, DM);
            Intent i = new Intent();
            i.setClassName(getApplicationContext(), "com.kuboche.myapplication.start");
            startActivity(i);
        }
    }
}
