package com.example.harvard.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.R;

public class ProgramViewHolder extends RecyclerView.ViewHolder {
    public TextView txtSTT, txtSubjectID, txtSubjectName, txtNumberOfPriod;

    public ProgramViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSTT = (TextView) itemView.findViewById(R.id.txtSTT);
        txtSubjectID = (TextView) itemView.findViewById(R.id.txtSubjectID);
        txtSubjectName = (TextView) itemView.findViewById(R.id.txtSubjectName);
        txtNumberOfPriod = (TextView) itemView.findViewById(R.id.txtNumberOfPriod);

    }
}
