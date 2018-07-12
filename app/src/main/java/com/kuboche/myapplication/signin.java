package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
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

import com.kuboche.bean.User;

import java.util.List;
import java.util.Locale;

public class signin extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);


        /*
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //拿到被选择项的值
                securityQuestion = (String) sp.getSelectedItem();
            }
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
*/
    }

    public void signin1(View v) {
        Intent i = new Intent();
        //获取输入的账号
        EditText editText1 = (EditText) findViewById(R.id.account);
        String account = editText1.getText().toString();
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


        if (accountIsExist(account)!=0 ){
            Toast.makeText(this, "该账号已存在！", Toast.LENGTH_LONG).show();
        }
        else if(passwordIsRight(pwd1, pwd2)) {
            User U1 = new User(account, null, pwd1, securityQuestion, securityAnswer);
            U1.save();
            i.setClassName(getApplicationContext(), "com.kuboche.myapplication.framework");
            startActivity(i);
            Toast.makeText(this, "注册成功！", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
        }
    }

    public void quit1(View v) {
        Intent i = new Intent();
        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.start");
        startActivity(i);
    }

    private boolean passwordIsRight(String pwd1, String pwd2) {
        return pwd1.equals(pwd2);
    }

    private int accountIsExist(String account) {
        List<User> userList = User.find(User.class, "account=? ", account);
        return  userList.size();
    }
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
