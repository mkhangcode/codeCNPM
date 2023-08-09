package com.example.harvard.admin.teacher.fragment.DayOfSchedule;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harvard.R;
import com.example.harvard.adapter.ScheduleAdapter;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Schedule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class SaturdayTeacherFragment extends Fragment {
    FirebaseDatabase database;
    DatabaseReference schedule;
    RecyclerView listSchedule;
    Context context;
    List<Schedule> schedules;
    ValueEventListener eventListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saturday_teacher, container, false);
        context = container.getContext();
        database = FirebaseDatabase.getInstance();
        schedule = database.getReference("Room").child(Common.currentTeacher.getTeachingInformation().getChuyenNganh() + "");
        listSchedule = (RecyclerView) view.findViewById(R.id.listSchedule);
        listSchedule.setHasFixedSize(true);
        listSchedule.setLayoutManager(new LinearLayoutManager(context));
        schedules = new ArrayList<>();
        ScheduleAdapter adapter = new ScheduleAdapter(schedules, context);
        adapter.notifyDataSetChanged();
        listSchedule.setAdapter(adapter);
        eventListener = schedule.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                schedules.clear();
                for(DataSnapshot itemsnapshot : snapshot.getChildren()){
                    if(itemsnapshot.child("Subject").child("time").getValue(String.class).equals("Bảy")){
                        Schedule subject = itemsnapshot.child("Subject").getValue(Schedule.class);
                        schedules.add(subject);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}