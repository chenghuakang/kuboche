package com.kuboche.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kuboche.bean.PackRecord;

import java.util.Date;
import java.util.List;

public class aboutme extends Activity implements AdapterView.OnItemClickListener{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutme);
        //要显示的数据
        String[] strs = {"我的账户","停车记录","账户信息","注销账户"};
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,strs);
        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    public String[] add(String[] strs, String str){
        String[] s =  new String[strs.length+1];
         int i = 0;
        for(String ax:strs){
            s[i] = ax;
            i++;
        }
        s[i] = str;
        return s;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        PackRecord p =  new PackRecord(49,"njnsajdk",6.646,new Date());
        p.save();
        p=new PackRecord(55,"FASHUIk",8.136,new Date());
        p.save();
        p=new PackRecord(79,"FASHUIk",8.136,new Date());
        p.save();
        p=new PackRecord(321,"FASHUIk",8.136,new Date());
        p.save();
        PackRecord p3 = PackRecord.findById(PackRecord.class,1);
        List<PackRecord> p2 = PackRecord.listAll(PackRecord.class);

        switch((int)l){
            case 0:
                break;
                case 1:
                    String[] strs = new String[p2.size()];
                        for(int j = 0;j<p2.size();j++){
                            strs[j] = "No"+j + "    " + p2.get(j).getName()+"  "+p2.get(j).getParkId()
                                    +"号停车场\n"+p2.get(j).getDate().toString();
                        }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>
                            (this,android.R.layout.simple_expandable_list_item_1,strs);
                    listView.setAdapter(adapter);
                    break;
            case 2:
                break;
                case 3:
                    break;
            case 4:
                break;

                default:
        }
    }
}
