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

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import java.util.Date;
import java.util.List;

import static com.orm.util.ContextUtil.getContext;

public class aboutme3{
    ListView listView;
    private static final String TAG = "GpsActivity";
    private LocationManager locationManager;
    private Context mContext;
    double x;
    double y;
    private Context context;
    AMapLocation a;
    ArrayAdapter<String> adapter3;
   // final AMapLocationClient mLocationClient=null;

    //声明定位回调监听器
    public void locate() {
        //声明AMapLocationClient类对象

//声明定位回调监听器
//初始化定位
        final AMapLocationClient mLocationClient = new AMapLocationClient(getContext());
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                if (amapLocation != null){
                    if (amapLocation.getErrorCode() == 0) {
                        a=amapLocation;
                        mLocationClient.stopLocation();
                    } else {
                        Log.e("AmapError", "location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                        Toast.makeText(getContext(), "定位失败"+amapLocation.getErrorCode(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "定位失败", Toast.LENGTH_LONG).show();
                }
            }

        };
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //声明AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = null;
//初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //mLocationOption.setOnceLocationLatest(true);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
//启动定位
        mLocationClient.startLocation();
    }


}
