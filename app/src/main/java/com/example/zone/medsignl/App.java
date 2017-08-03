package com.example.zone.medsignl;

import android.app.Application;
import android.graphics.Color;

import zone.com.zrefreshlayout.Config;
import zone.com.zrefreshlayout.footer.MeterialFooter;
import zone.com.zrefreshlayout.header.MeterialHead;
import zone.com.zrefreshlayout.resistance.DampingHalf;

/**
 * Created by Zone on 2015/12/16.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化 sqlite
        ImageLoaderOptionsUtils.initShowImage(R.drawable.ic_stub, R.drawable.ic_empty, R.drawable.ic_error);
        ImageLoaderConfigUtils.initImageLoader(App.this,ImageLoaderOptionsUtils.getNormalOption＿NotBuild().build(),false);

        int[] colors_red_green_yellow = new int[]{
                Color.parseColor("#ffF44336"),
                Color.parseColor("#ff4CAF50"),
                Color.parseColor("#ffFFEB3B")
        };
        Config.build()
                .setHeader(new MeterialHead(colors_red_green_yellow))
                .setFooter(new MeterialFooter())
                .setResistance(new DampingHalf())
//                .setHeader(new  CircleRefresh())
//                .setResistance(new Damping2Head8per())
                .writeLog(true)
                .perform();
    }
}
