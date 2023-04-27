package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonImage;
    TextView lutemonName, lutemonAttack, lutemonDefense, lutemonHealth, lutemonExperience, lutemonResult;
    public RadioButton rbBattle;
    public RadioButton rbTrain;
    public RadioButton rbBase;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);

        lutemonImage = itemView.findViewById(R.id.imgv);
        lutemonName = itemView.findViewById(R.id.txtvName);
        lutemonAttack = itemView.findViewById(R.id.txtvAttack);
        lutemonDefense = itemView.findViewById(R.id.txtvDefense);
        lutemonHealth = itemView.findViewById(R.id.txtvHealth);
        lutemonExperience = itemView.findViewById(R.id.txtvExperience);
        lutemonResult = itemView.findViewById(R.id.txtvResult);
        rbBase = itemView.findViewById(R.id.rbMoveBattle);
        rbTrain = itemView.findViewById(R.id.rbMoveTrain);
        rbBattle = itemView.findViewById(R.id.rbMoveBattle);
    }

}