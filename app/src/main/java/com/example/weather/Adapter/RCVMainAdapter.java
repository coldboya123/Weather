package com.example.weather.Adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Model.DateObject;
import com.example.weather.Model.HourObject;
import com.example.weather.R;

import java.util.Date;
import java.util.List;

public class RCVMainAdapter extends RecyclerView.Adapter<RCVMainAdapter.ViewHolder> {

    private Context context;
    private List<HourObject> hourObjectList;
    private List<DateObject> dateObjectList;
    private boolean isLast = false;
    private int visibleItem, scrolloutItem, totalItemCount;
    private int day = 14;

    public RCVMainAdapter(Context context, List<HourObject> hourObjectList, List<DateObject> dateObjectList) {
        this.context = context;
        this.hourObjectList = hourObjectList;
        this.dateObjectList = dateObjectList;
    }

    @NonNull
    @Override
    public RCVMainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_rcv_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RCVMainAdapter.ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
                holder.recyclerView.setAdapter(new RCVHourAdapter(context, hourObjectList));
                break;
            case 1:
                LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                RCVDateAdapter adapter = new RCVDateAdapter(context, dateObjectList);
                holder.recyclerView.setAdapter(adapter);
                holder.recyclerView.setLayoutManager(layoutManager);

                holder.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        totalItemCount = layoutManager.getItemCount();
                        visibleItem = layoutManager.getChildCount();
                        scrolloutItem = layoutManager.findFirstVisibleItemPosition();
                        if (dy > 0 && !isLast && totalItemCount == visibleItem + scrolloutItem){
                            isLast = true;
                            LoadMore();
                            notifyDataSetChanged();
                        }
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private void LoadMore() {
        new Handler().postDelayed(() -> {
            dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_03d_2x, "98/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
            dateObjectList.add(new DateObject(R.drawable.img_10d_2x, "96/80 °F", new Date(2020, 4, ++day)));
        }, 1500);
        isLast = false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv);
        }
    }

}
