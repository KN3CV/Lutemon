package com.example.lutemon;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrainingViewHolder extends RecyclerView.ViewHolder {

    TextView nameColor;

    public TrainingViewHolder(@NonNull View itemView) {
        super(itemView);
        nameColor = itemView.findViewById(R.id.txtvLutView);
    }
}
