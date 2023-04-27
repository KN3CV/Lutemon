package com.example.lutemon;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class ListLutemonAdapter extends RecyclerView.Adapter<ListViewHolder> {


    private Context context;
    private Storage storage;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private  ArrayList<Lutemon> baseLutemons;
    private View view;
    private Set<Lutemon> selectedLutemon;


    public ListLutemonAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;

        this.baseLutemons = new ArrayList<>();
        //Checking the right place and adding it to a new ArrayList
        for (Lutemon lutemon : lutemons){
            if (lutemon.getPlace() == 0){
                baseLutemons.add(lutemon);
            }
        }
        this.selectedLutemon = new HashSet<>();
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        storage = Storage.getInstance();
        Lutemon lutemon = baseLutemons.get(position);
        //if (lutemon.getPlace() == 0) {
            holder.lutemonName.setText(baseLutemons.get(position).getName() + " (" + baseLutemons.get(position).getColor() + ")");
            holder.lutemonAttack.setText("Attack: " + baseLutemons.get(position).getAttack());
            holder.lutemonDefense.setText("Defense: " + baseLutemons.get(position).getDefense());
            holder.lutemonHealth.setText("Health: " + baseLutemons.get(position).getHealth() + "/" + baseLutemons.get(position).getMaxHealth());
            holder.lutemonExperience.setText("Experience: " + baseLutemons.get(position).getExperience());
            holder.lutemonResult.setText(baseLutemons.get(position).getWins() + "-" + baseLutemons.get(position).getLosses());
            holder.lutemonImage.setImageResource(baseLutemons.get(position).getImage());
            int customColor = Color.rgb(251, 161, 114);
        holder.itemView.setBackgroundColor(customColor);

        holder.itemView.setOnClickListener(view -> {
            if (selectedLutemon.contains(lutemon)){
                selectedLutemon.remove(lutemon);
                baseLutemons.get(position).setChoose(0);
                holder.itemView.setBackgroundColor(customColor);
            } else {
                //if (selectedLutemon.size() < 1){
                    selectedLutemon.add(lutemon);
                    baseLutemons.get(position).setChoose(1);
                    holder.itemView.setBackgroundColor(Color.GREEN);
                //}
            }
        });

    }


    @Override
    public int getItemCount() {
        int count = 0;
        for (Lutemon lutemon : lutemons){
            if (lutemon.getPlace() == 0){
                count++;
            }
        }
        return count;
    }
}
