package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuboche.bean.User;

public class data3 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data3);

        Bundle bundle=getIntent().getExtras();
        String parkinfo=bundle.getString("parkinfo");
        String name = bundle.getString("name");
        Float price = bundle.getFloat("price");
        String phonenum = bundle.getString("phonenum");
        TextView tv=(TextView) findViewById(R.id.park);
        tv.setText(parkinfo);
    }
    public void bu1(View v){
        User u = User.findById(User.class,1);
        u.setParking(true);
        u.save();
        Bundle bundle=getIntent().getExtras();
        String name = bundle.getString("name");
        Float price = bundle.getFloat("price");
        String phonenum = bundle.getString("phonenum");
        SharedPreferences preferences1= getSharedPreferences("parkname", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences1.edit();
        editor.putString("name",name);
        editor.commit();
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phonenum));
        //sendIntent.setPackage("com.android.mms");
        sendIntent.putExtra("sms_body", u.getAccount() + "要在" + name + "停车" + ",每小时" + price + "元");
        startActivity(sendIntent);
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        Intent i = new Intent();
        i.setClassName(getApplicationContext(), "com.kuboche.myapplication.framework");
        startActivity(i);
    }
}
