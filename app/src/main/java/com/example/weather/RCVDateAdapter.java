package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RCVDateAdapter extends RecyclerView.Adapter<RCVDateAdapter.ViewHolder> {

    Context context;
    List<DateObject> list;

    public RCVDateAdapter(Context context, List<DateObject> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rcv_date_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DateObject object = list.get(position);
        holder.mtxtDate.setText(object.getDate().toString().split("00")[0]);
        holder.mtxtTemperature.setText(object.getTemperature());
        holder.mImg.setImageResource(object.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtxtDate, mtxtTemperature;
        ImageView mImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxtDate = itemView.findViewById(R.id.txtdate);
            mtxtTemperature = itemView.findViewById(R.id.temperature);
            mImg = itemView.findViewById(R.id.img);
        }
    }
}

