package com.example.zone.medsignl.Activity.frag;

import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zone.medsignl.R;

/**
 * Created by Zone on 2015/12/18.
 */
public class NormalFragment extends Fragment {
    private View mParentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mParentView = inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final TextView tv_clip = (TextView) view.findViewById(R.id.tv_clip);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tv_clip.setOutlineProvider(new ViewOutlineProvider() {
                @SuppressLint("NewApi")
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, tv_clip.getWidth(), tv_clip.getHeight(), 30);
//                    outline.setOval(0,0,tv_clip.getWidth(),tv_clip.getHeight());
                }
            });
        }
        final TextInputLayout inputLayout = (TextInputLayout) view.findViewById(R.id.textInput);

        final EditText ed_test = (EditText) view.findViewById(R.id.ed_test);
        ed_test.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                ed_test.setError("请输入手机号");
                System.out.println("1");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        inputLayout.setHint("请输入姓名:");

        EditText editText = inputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    inputLayout.setErrorEnabled(true);
                    inputLayout.setError("姓名长度不能超过4个");
                } else {
                    inputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snack = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
                snack.setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snack.dismiss();
                    }
                });
                snack.show();
            }
        });
        FloatingActionButton frameId = (FloatingActionButton) view.findViewById(R.id.frameId);
        frameId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snack = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
                snack.setAction("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snack.dismiss();
                    }
                });
                snack.show();
            }
        });
    }
}
