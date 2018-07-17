package com.kuboche.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;

import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.kuboche.bean.PackRecord;
import com.kuboche.bean.User;

import java.util.Date;
import java.util.List;
import android.view.View.OnClickListener;

import static com.orm.util.ContextUtil.getSharedPreferences;

public class aboutme extends Fragment implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayAdapter<String> adapter;
    View view;
    private static final String TAG = "GpsActivity";
    private LocationManager locationManager;
    private Context mContext;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.aboutme, container, false);
        //要显示的数据
        String[] strs = {"我的账户", "停车记录", "注销账户","我的位置"};
        //创建ArrayAdapter
        adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_expandable_list_item_1, strs);
        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
        listView = view.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (listView.getAdapter().equals(adapter)) {
            PackRecord p = new PackRecord("49", "njnsajdk", 6.646, new Date());
            p.save();
            p = new PackRecord("55", "FASHUIk", 8.136, new Date());
            p.save();
            p = new PackRecord("79", "FASHUIk", 8.136, new Date());
            p.save();
            p = new PackRecord("321", "FASHUIk", 8.136, new Date());
            p.save();
            PackRecord p3 = PackRecord.findById(PackRecord.class, 1);
            List<PackRecord> p2 = PackRecord.listAll(PackRecord.class);


            switch ((int) l) {
                case 0:
                    //读出账号
                    SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
                    String account=preferences.getString("data", "defaultname");
                    List<User> userList=User.find(User.class,"account=?",account);
                    //List<User> us = User.listAll(User.class);
                    if (!userList.isEmpty()) {
                        User us1 = userList.get(0);
                        String[] strs1 = {"账号： " + us1.getAccount(),"用户组：普通"};
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                                (getActivity(), android.R.layout.simple_expandable_list_item_1, strs1);
                        listView.setAdapter(adapter1);
                    } else {
                        Toast.makeText(getActivity(), "账号不存在", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 1:
                    String[] strs2 = new String[p2.size()];
                    for (int j = 0; j < p2.size(); j++) {
                        strs2[j] = "No" + j + "    " + p2.get(j).getName() + "  " + p2.get(j).getParkId()
                                + "号停车场\n" + p2.get(j).getDate().toString();
                    }
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                            (getActivity(), android.R.layout.simple_expandable_list_item_1, strs2);
                    listView.setAdapter(adapter2);
                    break;
                case 2:
                    Intent intent2 = new Intent();
                    intent2.setClassName(getActivity(), "com.kuboche.myapplication.start");
                    startActivity(intent2);
                    break;
                case 3:
                    if(!GPS.isGpsEnabled(getContext())){
                        Toast.makeText(getActivity(), "请打开网络或GPS定位功能!", Toast.LENGTH_SHORT).show();
                    }else if(!GPS.isLocationEnabled(getContext())){
                        Toast.makeText(getActivity(), "定位模块不可用", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double x = 50.049093587969466;
                        double y = 8.572699427604675;
                        GPS.getAddress(getContext(),x,y);
                        Date date = new Date();
                        String[] strs3 = new String[8];
                        strs3[0] = "卫星数：" + "7/17";
                        strs3[1] = "状态：" + "单点";
                        strs3[2] = "WGS84纬度：\n"+x ;
                        strs3[3] = "WGS84经度：\n" +y;
                        strs3[4] = "WGS84大地高：" + "46.20000";
                        strs3[5] = "时间：\n" + date.toString();
                        strs3[6] = "国家：" + GPS.getCountryName(getContext(),x,y);
                        strs3[7] = "街道：" + GPS.getStreet(getContext(),x,y);
                        ArrayAdapter<String> adapter3;
                        adapter3 = new ArrayAdapter<String>
                                (getActivity(), android.R.layout.simple_expandable_list_item_1, strs3);
                        listView.setAdapter(adapter3);
                }


                   /* if (!(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                            || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))) {
                        Toast.makeText(getActivity(), "请打开网络或GPS定位功能!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, 0);
                    return;}
                    try {
                        Location location;
                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if(location == null){
                            Log.d(TAG, "onCreate.location = null");
                            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        }
                        Log.d(TAG, "onCreate.location = " + location);
                        //updateView(location);

                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 5, locationListener);
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 5, locationListener);
                    }catch (SecurityException  e){
                        e.printStackTrace();
                    }*/
                    //GPS gps = new GPS();
                    //gps.initLocation(getActivity());


                    break;
                case 4:
                    break;
                default:
            }

        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.account2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(adapter);
                ;

            }
        });
    }


    private LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Log.d(TAG, "onProviderDisabled.location = " + location);
            // updateView(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d(TAG, "onStatusChanged() called with " + "provider = [" + provider + "], status = [" + status + "], extras = [" + extras + "]");
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.i(TAG, "AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.i(TAG, "OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.i(TAG, "TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.d(TAG, "onProviderEnabled() called with " + "provider = [" + provider + "]");
            try {
                Location location = locationManager.getLastKnownLocation(provider);
                Log.d(TAG, "onProviderDisabled.location = " + location);
                //updateView(location);
            }catch (SecurityException e){

            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d(TAG, "onProviderDisabled() called with " + "provider = [" + provider + "]");
        }
    };



}



