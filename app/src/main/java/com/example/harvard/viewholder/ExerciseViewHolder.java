package com.example.harvard.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harvard.Interface.ItemClickListener;
import com.example.harvard.R;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {
    public TextView txtSubjectName, txtTittle, txtContent, txtClassID, tittleCard;
//    private ItemClickListener itemClickListener;
    public CardView cardView;
    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSubjectName = (TextView) itemView.findViewById(R.id.txtSubjectName);
        txtContent = (TextView) itemView.findViewById(R.id.txtContent);
        txtClassID = (TextView) itemView.findViewById(R.id.txtClassID);
        tittleCard = (TextView) itemView.findViewById(R.id.tittleCard);
        txtTittle = (TextView) itemView.findViewById(R.id.txtTittle);
        cardView = (CardView) itemView.findViewById(R.id.mainCard);
    }
//    public void setItemClickListener(ItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }
//
//    @Override
//    public void onClick(View view) {
//        itemClickListener.onClick(view, getAdapterPosition(), false);
//    }
}
