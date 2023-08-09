package com.example.harvard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;
import com.example.harvard.oop.Result;
import com.example.harvard.viewholder.ResultViewHolder;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder>{
    List<Result> myResult;
    Context context;

    public ResultAdapter(List<Result> myResult, Context context) {
        this.myResult = myResult;
        this.context = context;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        Result result = myResult.get(position);
        holder.tittleCard.setText(result.getSubjectName());
        holder.txtStatus.setText("Trạng thái: " + result.getNote());
        holder.txtNumberOfPriod.setText("Số tín chỉ: " + result.getNumberOfPriod());
        holder.txtResult.setText("Tổng kết: " + result.getTotal());
        holder.txtResultHalfSemester.setText("Điểm giữa kì: "  + result.getMidtermPoint());
        holder.txtResultLastSemester.setText("Điểm cuối kì: " + result.getEndtermPoint());
        holder.txtNameSubject.setText(result.getSubjectName() + " (" + result.getSubjectID() + ")");
    }

    @Override
    public int getItemCount() {
        return myResult.size();
    }
}
