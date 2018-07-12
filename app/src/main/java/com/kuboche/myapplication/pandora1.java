package com.kuboche.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.kuboche.bean.pandora1DS;
import java.util.List;

public class pandora1 extends Activity {

    ListView listView;

    public void main(){
        pandora1DS carR = new pandora1DS("武汉洪山区附近",540,"18171372219","张先生","挺好的一个车位，大家快来买。");
        carR.save();
        carR = new pandora1DS("武汉大学",400,"18171370371","林女士","巨便宜的车位，很划算很方便。");
        carR.save();
        carR = new pandora1DS("武汉市武昌区附近",800,"13043247890","康先生","跳楼价！");
        carR.save();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pandora1);

        List<pandora1DS> carRentlist = pandora1DS.listAll(pandora1DS.class);//这行出的错
        String str[] = new String[carRentlist.size()];
        for(int i = 0; i < carRentlist.size();i++){
            //str[i] = "abc";
            str[i] =  "地理位置："+carRentlist.get(i).getLocation()+"\n简单介绍："+carRentlist.get(i).getIntroduction()+"\n联系人："
                    +carRentlist.get(i).getContactPerson()+"\n联系方式："+carRentlist.get(i).getContactWay();
            //str[i] = "地理位置：DASHIUWHDNCMSDLC,DSGHJKHMBNF"+ "\n简介：DASUILDJKSADNCM"+"\n联系人："+"\n联系方式:";
        }
        //问题：只能放三行
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,str);
        listView = (ListView) findViewById(R.id.pan1_listview);
        listView.setAdapter(adapter);
    }
}
