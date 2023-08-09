package com.example.harvard.admin.teacher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;
import com.example.harvard.admin.teacher.viewholder.ListStudentViewHolder;
import com.example.harvard.oop.Student;
import com.example.harvard.oop.Subject;
import com.example.harvard.viewholder.ProgramViewHolder;

import java.util.List;

public class ListStudentAdapter extends RecyclerView.Adapter<ListStudentViewHolder>{
    List<Student> studentList;
    Context context;

    public ListStudentAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }
    @NonNull
    @Override
    public ListStudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_student, parent, false);
        return new ListStudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListStudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.txtMSSV.setText(student.getStudentID());
        holder.txtSTT.setText(position + 1 + "");
        holder.txtTen.setText(student.getLastName() + "");
        holder.txtHoTenLot.setText(student.getFirstName() + "");
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
