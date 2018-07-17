package com.kuboche.myapplication;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

public class GPSUnit {

    public static void getCurrentLocation(Context context, LocationCallBack locationCallBack){
        if (locationCallBack == null){
            return;
        }
        if (context == null){
            locationCallBack.onFail("请确保传入的参数context不为null");
        }
        //如果系统版本号在23及其以上则检查权限
        //获取LocationManager对象
        LocationManager locationM = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        //实例化MyLocationListener
        MyLocationListener locationListener = new MyLocationListener(locationM, locationCallBack);
        //配置Criteria耗电低
        Criteria cri =  new Criteria();
        cri.setPowerRequirement(Criteria.POWER_LOW);
        // 获取可用的provider,第二个参数标识 provider是否可用.
        String bestProvider = locationM.getBestProvider(cri,true);
    }

    /**
     * LocationListener 的实现类
     */
    private static class MyLocationListener implements LocationListener {
        private LocationManager mLocationManager;
        private LocationCallBack mLocationCallBack;

        public MyLocationListener(LocationManager locationManager, LocationCallBack locationCallBack) {
            this.mLocationManager = locationManager;
            this.mLocationCallBack = locationCallBack;
        }

        @Override
        public void onLocationChanged(Location location) {
            if (location != null){
                if(mLocationCallBack != null){
                    mLocationCallBack.onSuccess(location);
                }
                if (mLocationManager != null){
                    mLocationManager.removeUpdates(this);
                }
            }else{
                if(mLocationCallBack != null){
                    mLocationCallBack.onFail("location == null");
                }
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    /**
     * 定位结果回调
     */
    public interface LocationCallBack{
        /**
         * 定位成功
         * @param location
         */
        void onSuccess(Location location);

        /**
         * 定位失败
         * @param msg
         */
        void onFail(String msg);
    }
}