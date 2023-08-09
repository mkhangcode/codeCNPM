package com.example.harvard.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.Interface.ItemClickListener;
import com.example.harvard.R;
import com.example.harvard.oop.Exercise;
import com.example.harvard.viewholder.ExerciseViewHolder;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {
    List<Exercise> exercises;
    Context context;

    public ExerciseAdapter(List<Exercise> exercises, Context context) {
        this.exercises = exercises;
        this.context = context;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_exercise, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.tittleCard.setText(exercise.getSubjectName() + "");
        holder.txtTittle.setText(exercise.getTitle() + "");
        holder.txtClassID.setText(exercise.getClassID() + "");
        holder.txtSubjectName.setText(exercise.getSubjectName() + "");
        holder.txtContent.setText(exercise.getContent() + "");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "Hiiii");
            }
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
