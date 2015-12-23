package com.example.zone.medsignl.Activity.frag;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.zone.medsignl.Images;
import com.example.zone.medsignl.R;
import com.example.zone.medsignl.RecyclerHolder.Adapter_Zone_Recycler;
import com.example.zone.medsignl.RecyclerHolder.MyRecyclerHolder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Zone on 2015/12/18.
 */
public class RecyclerFragment extends Fragment {
    private RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recyler_card_pattle, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recycler=(RecyclerView)view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> strList= Arrays.asList(Images.imageThumbUrls);
        recycler.setAdapter(new Adapter_Zone_Recycler<String>(getActivity(), strList, R.layout.card_item) {
            @Override
            public void setData(Map map, String data, int position, final MyRecyclerHolder holder) {
                ImageView iv = (ImageView) map.get(R.id.iv);
                ImageLoader.getInstance().displayImage(data, iv, new ImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {

                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                        System.err.println(failReason.getCause());
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        Palette.from(loadedImage).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                Palette.Swatch vibrant = palette.getVibrantSwatch();//有活力
                                if (vibrant != null) {
                                    holder.map.get(R.id.textView).setBackgroundColor(vibrant.getRgb());
//                                    holder.title.setBackgroundColor(vibrant.getRgb());
//                                    holder.title.setTextColor(
//                                            vibrant.getTitleTextColor());
                                }
                            }
                        });
                    }

                    @Override
                    public void onLoadingCancelled(String imageUri, View view) {

                    }
                });
            }
        });
    }
}
