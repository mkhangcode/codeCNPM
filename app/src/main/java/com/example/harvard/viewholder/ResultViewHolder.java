package com.example.harvard.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;

public class ResultViewHolder extends RecyclerView.ViewHolder{
    public TextView tittleCard, txtNameSubject, txtNumberOfPriod, txtResultHalfSemester, txtResultLastSemester,txtResult,txtStatus;
    public ResultViewHolder(@NonNull View itemView) {
        super(itemView);
        tittleCard = (TextView) itemView.findViewById(R.id.tittleCard);
        txtNameSubject = (TextView) itemView.findViewById(R.id.txtNameSubject);
        txtNumberOfPriod = (TextView) itemView.findViewById(R.id.txtNumberOfPriod);
        txtResultHalfSemester = (TextView) itemView.findViewById(R.id.txtResultHalfSemester);
        txtResultLastSemester = (TextView) itemView.findViewById(R.id.txtResultLastSemester);
        txtResult = (TextView) itemView.findViewById(R.id.txtResult);
        txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
    }
}
