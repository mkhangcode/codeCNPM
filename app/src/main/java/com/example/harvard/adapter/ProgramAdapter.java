package com.example.harvard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;
import com.example.harvard.oop.Subject;
import com.example.harvard.viewholder.ProgramViewHolder;

import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramViewHolder>{
    List<Subject> subjectList;
    Context context;

    public ProgramAdapter(List<Subject> subjectList, Context context) {
        this.subjectList = subjectList;
        this.context = context;
    }


    @NonNull
    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_program, parent, false);
        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.txtSTT.setText(position + 1 + "" );
        holder.txtSubjectName.setText(subject.getSubjectName() + "");
        holder.txtSubjectID.setText(subject.getSubjectID() + "");
        holder.txtNumberOfPriod.setText(subject.getNumberOfPriod() + "");
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}
