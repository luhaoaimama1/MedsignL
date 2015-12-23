package com.example.zone.medsignl;

import android.app.Application;

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
    }
}
