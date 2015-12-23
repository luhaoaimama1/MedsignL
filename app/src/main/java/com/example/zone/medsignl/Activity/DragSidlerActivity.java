package com.example.zone.medsignl.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zone.medsignl.Activity.fragUtils.SimpleFragmentPagerAdapter;
import com.example.zone.medsignl.Adapter_Zone;
import com.example.zone.medsignl.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Zone on 2015/12/16.
 */
public class DragSidlerActivity extends AppCompatActivity {

    private  DrawerLayout drawer_layout;
    private  static List<String> menu=new ArrayList<String>();
    static{
        menu.add("我黑风你啊");
        menu.add("变态");
        menu.add("无敌龙卷风");
    }

    private Adapter_Zone<String> adapter;
    private ListView drawer_list;
    private Toolbar mToolbar;
    private TabLayout tabs;
    private ViewPager viewPager;
    private SimpleFragmentPagerAdapter fragAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drag_silder);
        // 设置显示Toolbar

        drawer_layout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer_layout.openDrawer(GravityCompat.START);
        tabs=(TabLayout)findViewById(R.id.tabs);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        
        initNavigation();
        iniToolBar();
        initTab2ViewPager();





    }

    private void initTab2ViewPager() {

        fragAdapter=new SimpleFragmentPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(fragAdapter);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < fragAdapter.getCount(); i++) {
            TabLayout.Tab tab = tabs.getTabAt(i);
            tab.setCustomView(fragAdapter.getTabView(i));
        }
 //        List<String> tabList = new ArrayList<String>();
//        tabList.add("Tab1");
//        tabList.add("Tab2");
//        tabList.add("Tab3");
//        tabs.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
//        tabs.addTab(tabs.newTab().setText(tabList.get(0)));//添加tab选项卡
//        tabs.addTab(tabs.newTab().setText(tabList.get(1)));
//        tabs.addTab(tabs.newTab().setText(tabList.get(2)));
    }

    private void initNavigation() {
        adapter=new Adapter_Zone<String>(this,menu,R.layout.text_item) {
            @Override
            public void setData(Map<Integer, View> viewMap, final String data,final int position) {
                TextView tv = (TextView) viewMap.get(R.id.tv);
                tv.setText(data);
                viewMap.get(R.id.ll).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DragSidlerActivity.this, "点击了"+data, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        drawer_list=(ListView)findViewById(R.id.drawer_list);
        drawer_list.setAdapter(adapter);
    }

    private void iniToolBar() {
        mToolbar=(Toolbar)findViewById(R.id.id_toolbar);
        //这句话　是把onCreateOptionsMenu　里面创建的菜单　加载上
        setSupportActionBar(mToolbar);
//        // 设置Drawerlayout开关指示器，即Toolbar最左边的那个icon
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer_layout, mToolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mActionBarDrawerToggle.syncState();
        drawer_layout.setDrawerListener(mActionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "查找按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawers();
        }else{
            drawer_layout.openDrawer(GravityCompat.START);
        }

    }
}
