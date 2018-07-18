package com.kuboche.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import static com.orm.util.ContextUtil.getContext;

public class aboutme3 extends Activity{
    ListView listView;
    private static final String TAG = "GpsActivity";
    private LocationManager locationManager;
    private Context mContext;
    double x;
    double y;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutme3);
        context=this;
        if (!GPS.isGpsEnabled(getContext())) {
            Toast.makeText(this, "请打开网络或GPS定位功能!", Toast.LENGTH_SHORT).show();
        } else if (!GPS.isLocationEnabled(getContext())) {
            Toast.makeText(this, "定位模块不可用", Toast.LENGTH_SHORT).show();
        } else {

            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            {
                //获取所有可用的位置提供器
                List<String> providers = locationManager.getProviders(true);
                String locationProvider;
                if (providers.contains(LocationManager.GPS_PROVIDER)) {
                    //如果是GPS
                    locationProvider = LocationManager.GPS_PROVIDER;
                } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
                    //如果是Network
                    locationProvider = LocationManager.NETWORK_PROVIDER;
                } else {
                    Toast.makeText(this, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 调用getLastKnownLocation()方法获取当前的位置信息
                Location location = locationManager.getLastKnownLocation(locationProvider);
                if (location != null) {
                    x = location.getLatitude();//获取纬度
                    y = location.getLongitude();//获取经度
                }
            }
        }
      /* GPSUnit.getCurrentLocation(getContext(),);
       x=50.049093587969466;
       y=8.572699427604675;*/
        GPS.getAddress(getContext(), x, y);
        Date date = new Date();
        String[] strs3 = new String[8];
        strs3[0] = "卫星数：" + "7/17";
        strs3[1] = "状态：" + "单点";
        strs3[2] = "WGS84纬度：\n" + x;
        strs3[3] = "WGS84经度：\n" + y;
        strs3[4] = "WGS84大地高：" + "46.20000";
        strs3[5] = "时间：\n" + date.toString();
        strs3[6] = "国家：" + GPS.getCountryName(getContext(), x, y);
        strs3[7] = "街道：" + GPS.getStreet(getContext(), x, y);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, strs3);
        listView = (ListView) findViewById(R.id.aboutmelist3);
        listView.setAdapter(adapter3);
    }

}
