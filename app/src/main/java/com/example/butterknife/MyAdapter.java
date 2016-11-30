package com.example.butterknife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by smg on 2016/11/30.
 */

public class MyAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_main, viewGroup);

        return null;
    }

    public class ViewHolder {
        @BindView(R.id.tv_Show)
        TextView tvShow;
        @BindView(R.id.btn1)
        Button btn1;
        @BindView(R.id.btn2)
        Button btn2;
        @BindView(R.id.main_activity_listView)
        ListView mainActivityListView;
        @BindView(R.id.activity_main)
        LinearLayout activityMain;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
