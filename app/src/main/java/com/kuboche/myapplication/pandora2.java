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

    public void main() {
        pandora2DS carService = new pandora2DS("天行汽车美容中心", "武汉市洪山区珞喻路", 708.00, "18171370371", 114.3680, 30.5077);
        carService.save();
        carService = new pandora2DS("向创汽车服务中心", "武汉市武昌区", 800, "18171372219", 114.3682, 30.5078);
        carService.save();
        carService = new pandora2DS("申通汽车服务中心", "武汉市洪山区", 900, "18171372210", 114.3683, 30.5077);
        carService.save();
        carService = new pandora2DS("天下汽车服务","武汉市桂中路",781.2,"18171311234",114.3678,30.5076);
        carService.save();
        carService = new pandora2DS("韵达汽车服务中心","武汉市珞喻路",771.0,"18171318834",114.3679,30.5070);
        carService.save();
        carService = new pandora2DS("奇山汽修","武汉市珞南街道",677.0,"18171313333",114.3666,30.5066);
        carService.save();
        carService = new pandora2DS("武昌汽车服务","武汉市洪山区",999,"18171315678",114.3600,30.5076);
        carService.save();
        carService = new pandora2DS("中通汽车服务中心","武汉市桂中路",666,"18171311234",114.3670,30.5076);
        carService.save();
        carService = new pandora2DS("百世汽车服务中心","武汉市桂中路",886,"18122293800",114.3677,30.5000);
        carService.save();
        carService = new pandora2DS("红山汽车服务中心","武汉市狮子街",666,"18171311334",114.3670,30.5076);
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
       // aboutme3 a = new aboutme3();
        //a.locate();
        double desX = 114.3670;
        double desY = 30.5076;//传进来的位置
        //搜索相关地理位置，扔进新的列表中
        for (int i = 0; i < carS.size(); i++) {
            if (calculateDistance.main(desX, desY, carS.get(i).getX(), carS.get(i).getY()) <= 5000) {
                carDes.add(carS.get(i));
            }
        }

        String str2[] = new String[carDes.size()];
        for (int i = 0; i < carDes.size(); i++) {
            str2[i] = "名称：" + carDes.get(i).getName() + "   人均消费：" + carDes.get(i).getAverageCost()
                    + "\n位置：" + carDes.get(i).getLocation() + "\n联系方式：" + carDes.get(i).getContactWay();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, str2);
        listView = (ListView) findViewById(R.id.pan2_listview);
        listView.setAdapter(adapter);
    }
}






