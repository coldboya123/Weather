package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RCVMainAdapter extends RecyclerView.Adapter<RCVMainAdapter.ViewHolder> {

    Context context;
    List<HourObject> hourObjectList;
    List<DateObject> dateObjectList;

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
                holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
                holder.recyclerView.setAdapter(new RCVDateAdapter(context, dateObjectList));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv);
        }
    }
}
