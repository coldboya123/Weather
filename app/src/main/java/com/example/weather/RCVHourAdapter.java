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

public class RCVHourAdapter extends RecyclerView.Adapter<RCVHourAdapter.ViewHolder> {

    Context context;
    List<HourObject> list;

    public RCVHourAdapter(Context context, List<HourObject> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_rcv_hour_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HourObject object = list.get(position);
        String hour = object.getHour() > 12 ? object.getHour() % 2 + "pm" : object.getHour() + "am";
        holder.mtxtHour.setText(hour);
        holder.mtxtTemperature.setText(object.getTemperature());
        holder.mImg.setImageResource(object.getImg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtxtHour, mtxtTemperature;
        ImageView mImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxtHour = itemView.findViewById(R.id.txthour);
            mtxtTemperature = itemView.findViewById(R.id.temperature);
            mImg = itemView.findViewById(R.id.img);
        }
    }
}
