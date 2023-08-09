package com.example.harvard.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;
import com.example.harvard.oop.Schedule;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ScheduleViewHolder extends RecyclerView.ViewHolder{
    public TextView tittleCard, txtRoom, txtSub, txtNumOfPriod, txtDay, txtLectuer;
    public ScheduleViewHolder(@NonNull View itemView) {
        super(itemView);
        tittleCard = (TextView) itemView.findViewById(R.id.tittleCard);
        txtSub = (TextView) itemView.findViewById(R.id.txtSub);
        txtRoom = (TextView) itemView.findViewById(R.id.txtRoom);
        txtNumOfPriod = (TextView) itemView.findViewById(R.id.txtNumOfPriod);
        txtDay = (TextView) itemView.findViewById(R.id.txtDay);
        txtLectuer = (TextView) itemView.findViewById(R.id.txtLectuer);
    }
}
