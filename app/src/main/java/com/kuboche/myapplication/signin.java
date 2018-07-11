package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kuboche.bean.User;

public class signin extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
    }
    public void signin1(View v){
        Intent i = new Intent();
        EditText editText1=(EditText)findViewById(R.id.account);
        String account = editText1.getText().toString();
        EditText editText2=(EditText)findViewById(R.id.pwd1);
        String pwd1 = editText2.getText().toString();
        EditText editText3=(EditText)findViewById(R.id.pwd2);
        String pwd2 = editText3.getText().toString();
        if(passwordIsRight(pwd1,pwd2)){
            User U1 = new User(account,null,pwd1,"abc","abc");
            U1.save();
            i.setClassName(getApplicationContext(),"com.kuboche.myapplication.framework");
            startActivity(i);
            Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();}
    }
    public void quit1(View v){
        Intent i = new Intent();
        i.setClassName(getApplicationContext(),"com.kuboche.myapplication.start");
        startActivity(i);
    }
    private boolean passwordIsRight(String pwd1,String pwd2){
        return pwd1.equals(pwd2);
    }
}
