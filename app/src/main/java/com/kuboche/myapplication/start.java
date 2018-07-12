package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kuboche.bean.PackRecord;
import com.kuboche.bean.User;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class start extends Activity {

    public void main() {
        User U1;
        U1 = new User("18171370371", "可可", "123456", "爸爸的生日", "8月7日");
        U1.save();
        U1.delete();
        U1 = new User("18171370372", "小可可", "1234567", "爸爸的生日", "8月7日");
        U1.save();
        U1.delete();
        U1 = new User("18171370373", "大可可", "12345678", "爸爸的生日", "8月7日");
        U1.save();
        U1.delete();
        U1 = new User("18171370378", "大可可", "12345678", "爸爸的生日", "8月7日");
        U1.save();
        U1.delete();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        //main();

        PackRecord p = new PackRecord("111", "njnsajdk", 6.646, new Date());
        p.save();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void logIn(View v) {
        Intent i = new Intent();
        EditText editText1 = (EditText) findViewById(R.id.account);
        String account = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.password);
        String password = editText2.getText().toString();

        List<User> userList = User.find(User.class, "account=? and password=?", account, password);
        if (userList.size() > 0) {
            i.setClassName(getApplicationContext(), "com.kuboche.myapplication.framework");
            startActivity(i);
            /*setContentView(R.layout.framework);*/
        } else {
            Toast.makeText(this, "密码错误", Toast.LENGTH_LONG).show();
        }
    }

    public void signIn(View v) {
        Intent i = new Intent();
        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.signin");
        startActivity(i);
    }

    public void password1(View v) {
        Intent i = new Intent();
        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.change_password1");
        startActivity(i);
    }

    private boolean passwordIsRight(String password1, String password2) {
        return password1.equals(password2);
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

