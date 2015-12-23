package com.example.zone.medsignl.RecyclerHolder;

import android.view.View;

import com.example.zone.medsignl.ViewIDsUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zone on 2015/12/16.
 */
public class MyRecyclerHolder extends android.support.v7.widget.RecyclerView.ViewHolder{
    private int[] idArray;// 得到一个LayoutInfalter对象用来导入布局
    public Map<Integer,View> map=new HashMap<Integer, View>();
    public MyRecyclerHolder(View convertView) {
        super(convertView);
        //把id 都找出来
        List<Integer> idList = ViewIDsUtils.getIDsByView(convertView);
        idArray=new int[idList.size()];
        for (int i = 0; i < idList.size(); i++) {
            idArray[i]=idList.get(i);
        }
        for (int i = 0; i < idArray.length; i++) {
            //给 convertView的每个控件 放入map 中易于取出
            map.put(idArray[i], convertView.findViewById(idArray[i]));
        }
    }
}