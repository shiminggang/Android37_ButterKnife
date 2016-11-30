package com.example.butterknife;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    //绑定视图
    @BindView(R.id.tv_Show)
    TextView tvShow;

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.btn2)
    Button btn2;

    @BindView(R.id.main_activity_listView)
    ListView listView;


    //绑定资源
    @BindColor(R.color.colorAccent)
    int colorAccent;

    @BindString(R.string.text_name)
    String appName;

    @BindDimen(R.dimen.activity_show_size)
    float textSize;

    @BindDrawable(R.drawable.ic_launcher)
    Drawable icon;


    //成员变量
    private Unbinder bind;
    private List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);

        //测试视图及资源是否被绑定
        tvShow.setTextColor(colorAccent);
        tvShow.setText(appName);
        tvShow.setTextSize(textSize);

        stringList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            stringList.add("测试条目" + i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringList);

        listView.setAdapter(adapter);
    }

    @OnItemClick(R.id.main_activity_listView)
    public void mainItemClick(int position) {
        Toast.makeText(this, stringList.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    /**
     * ButterKnife绑定多个监听接口，用大括号隔开id(监听器方法的参数是可选的，可以为空，可以为具体类型，它会被自动转型)
     */
    @OnClick({R.id.btn1, R.id.btn2})

    public void setBtn1(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Toast.makeText(this, "测试ButterKnife绑定监听接口1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2:
                Toast.makeText(this, "测试ButterKnife绑定监听接口2", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
