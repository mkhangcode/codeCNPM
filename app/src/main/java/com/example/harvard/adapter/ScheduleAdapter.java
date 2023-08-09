package com.example.harvard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;
import com.example.harvard.oop.Schedule;
import com.example.harvard.viewholder.ScheduleViewHolder;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {
    List<Schedule> mySchedule;
    Context context;

    public ScheduleAdapter(List<Schedule> myOrders, Context context) {
        this.mySchedule = myOrders;
        this.context = context;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Schedule schedule = mySchedule.get(position);
        holder.txtSub.setText(schedule.getSubjectName() + " (" + schedule.getSubjectID() + ")");
        holder.txtDay.setText(schedule.getStartDay() + " - " + schedule.getEndDay());
        holder.tittleCard.setText(schedule.getSubjectName());
        holder.txtNumOfPriod.setText(schedule.getLesson());
        holder.txtRoom.setText(schedule.getRoom() + " - " + schedule.getClassID());
        holder.txtLectuer.setText(schedule.getLectuer() + "");
    }

    @Override
    public int getItemCount() {
        return mySchedule.size();
    }
}
