package com.kuboche.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kuboche.bean.pandora2DS;
import com.kuboche.myapplication.calculateDistance;
import java.util.ArrayList;
import java.util.List;

public class pandora2 extends Activity {
    ListView listView;
    public  void main(){
        pandora2DS carService = new pandora2DS("天行汽车美容中心","武汉市洪山区珞喻路152号",708.00,"18171370371",44.2343,50.1234);
        carService.save();
        carService = new pandora2DS("向创汽车服务中心","武汉市武昌区",800,"18171372219",44.2333,50.1111);
        carService.save();
        carService = new pandora2DS("申通汽车服务中心","河南信阳市",900,"18171372210",44.2266,50.1411);
        carService.save();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pandora2);

        main();
        //List<pandora2DS> carDes = pandora2DS.listAll(pandora2DS.class);
        List<pandora2DS> carS = pandora2DS.listAll(pandora2DS.class);
        List<pandora2DS> carDes = new ArrayList<pandora2DS>();
        double desX = 44.223;
        double desY = 50.111;//传进来的位置
        //搜索相关地理位置，扔进新的列表中
        for(int i = 0; i < carS.size(); i++){
            if(calculateDistance.main(desX,desY,carS.get(i).getX(),carS.get(i).getY()) <= 5000){
                carDes.add(carS.get(i));
            }
        }

        String str2[] = new String[carDes.size()];
        for(int i = 0; i < carDes.size();i++){
            str2[i] = "名称："+carDes.get(i).getName()+"   人均消费："+carDes.get(i).getAverageCost()
                    +"\n位置："+carDes.get(i).getLocation()+"\n联系方式："+carDes.get(i).getContactWay();
        }
        //String[] str2 = {"dsa\ndsa\ndsa\ndsa\n","dsa\ndsa\ndsa\ndsa\n","dsa\ndsa\ndsa\ndsa\n","dsa\ndsa\ndsa\ndsa\n"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,str2);
        listView = (ListView) findViewById(R.id.pan2_listview);
        listView.setAdapter(adapter);

    }
}






