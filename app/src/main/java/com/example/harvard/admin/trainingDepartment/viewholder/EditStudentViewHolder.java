package com.example.harvard.admin.trainingDepartment.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;

public class EditStudentViewHolder extends RecyclerView.ViewHolder{
    public TextView txtSTT, txtMSSV, txtHoTenLot, txtTen;
    public ImageButton editStudent;
    public EditStudentViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSTT = (TextView) itemView.findViewById(R.id.txtSTT);
        txtMSSV = (TextView) itemView.findViewById(R.id.txtMSSV);
        txtHoTenLot = (TextView) itemView.findViewById(R.id.txtHoTenLot);
        txtTen = (TextView) itemView.findViewById(R.id.txtTen);
        editStudent = (ImageButton) itemView.findViewById(R.id.editStudent);
    }
}
