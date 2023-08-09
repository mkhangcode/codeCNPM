package com.example.harvard.admin.teacher.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;

public class ListStudentViewHolder extends RecyclerView.ViewHolder{
    public TextView txtSTT, txtMSSV, txtHoTenLot, txtTen;
    public ListStudentViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSTT = (TextView) itemView.findViewById(R.id.txtSTT);
        txtMSSV = (TextView) itemView.findViewById(R.id.txtMSSV);
        txtHoTenLot = (TextView) itemView.findViewById(R.id.txtHoTenLot);
        txtTen = (TextView) itemView.findViewById(R.id.txtTen);
    }
}
