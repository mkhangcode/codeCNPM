package com.example.harvard.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.harvard.R;
import com.example.harvard.activity.MainActivity;
import com.example.harvard.activity.ProgramActivity;
import com.example.harvard.activity.ResultActivity;
import com.example.harvard.activity.ScheduleActivity;
import com.example.harvard.adapter.ExerciseAdapter;
import com.example.harvard.common.Common;
import com.example.harvard.oop.Exercise;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    ImageButton btnSchedule, btnStudyResult, btnProgram;
    RecyclerView listExercise;
    List<Exercise> exerciseList;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference, databaseReference1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Context context = container.getContext();
        firebaseDatabase = FirebaseDatabase.getInstance();
        AnhXa(view, context);
        databaseReference = firebaseDatabase.getReference("Room").child(Common.currentUser.getCourseInfo().getChuyenNganh() + "");

        databaseReference1 = firebaseDatabase.getReference("students").child(Common.currentUser.getStudentID() + "").child("Schedule").child(Common.currentUser.getCourseInfo().getNamHocHienTai() + "");
        DatabaseReference databaseReference2 = databaseReference1.child(  Common.currentUser.getCourseInfo().getHocKiHienTai() + "");

        exerciseList = new ArrayList<>();
        ExerciseAdapter adapter = new ExerciseAdapter(exerciseList,context);
        adapter.notifyDataSetChanged();
        listExercise.setAdapter(adapter);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot2) {
                        exerciseList.clear();
                        for(DataSnapshot item1 : snapshot1.getChildren()){
                            for(DataSnapshot item2 : snapshot2.getChildren()){
                                for(DataSnapshot item3 : item2.getChildren()){
                                    if(item1.getKey().equals(item3.child("classID").getValue(String.class) + "")){
                                        for(DataSnapshot item4 : item1.child("Exercise").getChildren()){
                                            Exercise  exercise = item4.getValue(Exercise.class);
                                            exerciseList.add(exercise);
                                        }
                                    }
                                }
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ScheduleActivity.class));
            }
        });
        btnStudyResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResultActivity.class));
            }
        });
        btnProgram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ProgramActivity.class));
            }
        });
        return view;
    }

    private void AnhXa(View view, Context context) {
        btnSchedule = (ImageButton) view.findViewById(R.id.btnSchedule);
        btnStudyResult = (ImageButton) view.findViewById(R.id.btnStudyResult);
        btnProgram = (ImageButton) view.findViewById(R.id.btnProgram);
        listExercise = (RecyclerView) view.findViewById(R.id.listExercise);
        listExercise.setHasFixedSize(true);
        listExercise.setLayoutManager(new LinearLayoutManager(context));
    }


}