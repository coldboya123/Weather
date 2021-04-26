package com.example.weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.weather.Model.DateObject;
import com.example.weather.OnItemSelect;
import com.example.weather.R;

import java.util.List;

public class RCVDateAdapter extends RecyclerView.Adapter<RCVDateAdapter.ViewHolder> {

    private Context context;
    private List<DateObject> list;
    private final ViewBinderHelper binderHelper = new ViewBinderHelper();
    private OnItemSelect onItemSelect;

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
        String date = object.getDate().toString().split(" 00")[0];
        holder.mtxtDate.setText(date);
        holder.mtxtTemperature.setText(object.getTemperature());
        holder.mImg.setImageResource(object.getImg());
        binderHelper.bind(holder.swipeRevealLayout, date);
        holder.btndel.setOnClickListener(v -> {
//            onItemSelect.onDel(position);
            list.remove(position);
            notifyDataSetChanged();
        } );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mtxtDate, mtxtTemperature;
        ImageView mImg;
        SwipeRevealLayout swipeRevealLayout;
        Button btndel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mtxtDate = itemView.findViewById(R.id.txtdate);
            mtxtTemperature = itemView.findViewById(R.id.temperature);
            mImg = itemView.findViewById(R.id.img);
            swipeRevealLayout = itemView.findViewById(R.id.swipereveallayout);
            btndel = itemView.findViewById(R.id.btndel);
        }
    }

    public void SetOnItemCickRecyclerView(OnItemSelect onItemSelect){
        this.onItemSelect = onItemSelect;
    }
}

