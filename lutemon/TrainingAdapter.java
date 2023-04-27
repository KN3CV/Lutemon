package com.example.lutemon;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private Set<Lutemon> selectedLutemon;
    private Storage storage;
    private ArrayList<Lutemon> trainLutemons;

    public TrainingAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
        this.trainLutemons = new ArrayList<>();
        //Checking the right place and adding it to a new ArrayList
        for (Lutemon lutemon : lutemons){
            if (lutemon.getPlace() == 1){
                trainLutemons.add(lutemon);
            }
        }
        this.selectedLutemon = new HashSet<>();
    }
    @NonNull
    @Override
    public TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainingViewHolder((LayoutInflater.from(context).inflate(R.layout.battle_view, parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingViewHolder holder, int position) {
        storage = Storage.getInstance();
        Lutemon lutemon = trainLutemons.get(position);
        holder.nameColor.setText(trainLutemons.get(position).getName() + " (" + trainLutemons.get(position).getColor() + ")");
        holder.itemView.setBackgroundColor(Color.RED);

        holder.itemView.setOnClickListener(view -> {
            if (selectedLutemon.contains(lutemon)){
                selectedLutemon.remove(lutemon);
                trainLutemons.get(position).setChoose(0);
                holder.itemView.setBackgroundColor(Color.RED);
            } else {
                if (selectedLutemon.size() < 1){
                    selectedLutemon.add(lutemon);
                    trainLutemons.get(position).setChoose(1);
                    holder.itemView.setBackgroundColor(Color.GREEN);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (Lutemon lutemon : lutemons){
            if (lutemon.getPlace() == 1){
                count++;
            }
        }
        return count;
    }
}
