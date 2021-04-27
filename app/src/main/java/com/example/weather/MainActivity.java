package com.example.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Adapter.RCVMainAdapter;
import com.example.weather.Model.DateObject;
import com.example.weather.Model.HourObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<HourObject> hourObjectList;
    List<DateObject> dateObjectList;
    int day = 0;
    NestedScrollView nestedScrollView;
    RCVMainAdapter adapter;
    boolean isLast = false;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nestedScrollView = findViewById(R.id.parnetlayout);

        recyclerView = findViewById(R.id.rcv);
        getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RCVMainAdapter(this, hourObjectList, dateObjectList);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (v.getChildAt(v.getChildCount() - 1) != null) {
                if (scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())
                        && scrollY > oldScrollY && !isLast) {
                    isLast = true;
                    LoadMore();
                }
            }

        });
    }

    private void LoadMore() {
        dateObjectList.add(null);
        adapter.NotifyDateInsert();
        new Handler().postDelayed(() -> {
            dateObjectList.remove(dateObjectList.size() - 1);
            dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            adapter.NotifyDateRecyclerView();
            isLast = false;
        }, 1500);
    }

    private void getData() {
        hourObjectList = new ArrayList<>();
        hourObjectList.add(new HourObject(R.drawable.img_04n_2x, "83 °F", 1));
        hourObjectList.add(new HourObject(R.drawable.img_04n_2x, "83 °F", 2));
        hourObjectList.add(new HourObject(R.drawable.img_04n_2x, "82 °F", 3));
        hourObjectList.add(new HourObject(R.drawable.img_04n_2x, "81 °F", 4));
        hourObjectList.add(new HourObject(R.drawable.img_09d_2x, "81 °F", 5));
        hourObjectList.add(new HourObject(R.drawable.img_10d_2x, "81 °F", 6));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "83 °F", 7));
        hourObjectList.add(new HourObject(R.drawable.img_03d_2x, "87 °F", 8));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "90 °F", 9));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "93 °F", 10));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "95 °F", 11));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "99 °F", 12));
        hourObjectList.add(new HourObject(R.drawable.img_10d_2x, "97 °F", 13));
        hourObjectList.add(new HourObject(R.drawable.img_10d_2x, "94 °F", 14));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "92 °F", 15));
        hourObjectList.add(new HourObject(R.drawable.img_10d_2x, "91 °F", 16));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "90 °F", 17));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "87 °F", 18));
        hourObjectList.add(new HourObject(R.drawable.img_09d_2x, "85 °F", 19));
        hourObjectList.add(new HourObject(R.drawable.img_09d_2x, "84 °F", 20));
        hourObjectList.add(new HourObject(R.drawable.img_09d_2x, "84 °F", 21));
        hourObjectList.add(new HourObject(R.drawable.img_09d_2x, "83 °F", 22));
        hourObjectList.add(new HourObject(R.drawable.img_04d_2x, "82 °F", 23));
        hourObjectList.add(new HourObject(R.drawable.img_09d_2x, "82 °F", 24));

        dateObjectList = new ArrayList<>();
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "93/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "98/81 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "94/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "92/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "93/79 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_04d_2x, "94/79 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
        dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
    }
}