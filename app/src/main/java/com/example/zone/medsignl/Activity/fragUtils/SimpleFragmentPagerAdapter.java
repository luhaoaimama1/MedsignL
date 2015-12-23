package com.example.zone.medsignl.Activity.fragUtils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zone.medsignl.Activity.frag.NormalFragment;
import com.example.zone.medsignl.Activity.frag.RecyclerFragment;
import com.example.zone.medsignl.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zone on 2015/12/16.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"tab1","tab2"};
    private List<Fragment> fragList =new ArrayList<Fragment>();
    private Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
        fragList.add(new RecyclerFragment());
        fragList.add(new NormalFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//         return tabTitles[position];
         return null;
    }
    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView tv= (TextView) view.findViewById(R.id.textView);
        tv.setText(tabTitles[position]);
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(R.drawable.ic_error);
        return view;
    }
}