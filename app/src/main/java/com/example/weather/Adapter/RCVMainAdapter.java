package com.example.weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Model.DateObject;
import com.example.weather.Model.HourObject;
import com.example.weather.R;

import java.util.List;

public class RCVMainAdapter extends RecyclerView.Adapter<RCVMainAdapter.ViewHolder> {

    private final Context context;
    private final List<HourObject> hourObjectList;
    private final List<DateObject> dateObjectList;
    private RCVDateAdapter dateAdapter;

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
                LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                dateAdapter = new RCVDateAdapter(context, dateObjectList);
                holder.recyclerView.setAdapter(dateAdapter);
                holder.recyclerView.setLayoutManager(layoutManager);

                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void NotifyDateRecyclerView() {
        dateAdapter.notifyDataSetChanged();
    }

    public void NotifyDateInsert() {
        dateAdapter.notifyItemInserted(dateObjectList.size() - 1);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv);
        }
    }


}
