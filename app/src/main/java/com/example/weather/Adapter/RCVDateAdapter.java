package com.example.weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public class RCVDateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DateObject> list;
    private final ViewBinderHelper binderHelper = new ViewBinderHelper();
    private final int ITEMVIEW = 0, LOADINGVIEW = 1;

    public RCVDateAdapter(Context context, List<DateObject> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case ITEMVIEW:
                v = LayoutInflater.from(context).inflate(R.layout.item_rcv_date_layout, parent, false);
                return new ViewHolder(v);
            case LOADINGVIEW:
                v = LayoutInflater.from(context).inflate(R.layout.loading_layout, parent, false);
                return new LoadingHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            DateObject object = list.get(position);
            String date = object.getDate().toString().split(" 00")[0];
            ((ViewHolder) holder).mtxtDate.setText(date);
            ((ViewHolder) holder).mtxtTemperature.setText(object.getTemperature());
            ((ViewHolder) holder).mImg.setImageResource(object.getImg());
            binderHelper.bind(((ViewHolder) holder).swipeRevealLayout, date);
            ((ViewHolder) holder).btndel.setOnClickListener(v -> {
                list.remove(position);
                notifyDataSetChanged();
            });
        } else if (holder instanceof LoadingHolder) {
            ((LoadingHolder) holder).progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position) != null ? ITEMVIEW : LOADINGVIEW;
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

    public class LoadingHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;

        public LoadingHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.loading);
        }
    }
}

