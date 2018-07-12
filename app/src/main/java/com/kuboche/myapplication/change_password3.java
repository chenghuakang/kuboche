package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

public class change_password3 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password3);
    }
    public void password4(View v){
        Intent i = new Intent();
        EditText editText1 = (EditText) findViewById(R.id.account);
        String account = editText1.getText().toString();
        //获取输入的密码
        EditText editText2 = (EditText) findViewById(R.id.pwd1);
        String pwd1 = editText2.getText().toString();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
        startActivity(i);
    }

}