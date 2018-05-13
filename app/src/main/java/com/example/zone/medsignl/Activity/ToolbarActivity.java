package com.example.zone.medsignl.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.zone.medsignl.R;

/**
 * [2018] by Zone
 */

public class ToolbarActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test);

        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        // 不设置的话  导航按钮不显示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        toolbar.setLogo(R.drawable.ic_launcher);
        //可以清除logo  标题与子标题 同理 导航icon同理
        toolbar.setLogo(null);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //如果在setSupportActionBar 之后设置主标题
        // 需要setDisplayShowTitleEnabled(false)不然默认使用label Name
        toolbar.setTitle("主标题");
        //文字颜色
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));

        toolbar.setSubtitle("副标题");
        toolbar.setSubtitleTextColor(Color.RED);
        toolbar.setNavigationIcon(R.drawable.ic_stub);
        //设置背景色
        toolbar.setBackgroundColor(Color.GREEN);

        //隐藏 actionbar
        getSupportActionBar().hide();

        //显示 actionbar
        getSupportActionBar().show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "导航按钮", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_edit:
                Toast.makeText(this, "查找按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "按钮1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings2:
                Toast.makeText(this, "按钮2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
