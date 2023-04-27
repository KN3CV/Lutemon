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

public class BattleAdapter extends RecyclerView.Adapter<BattleViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private Set<Lutemon> selectedLutemon;
    private Storage storage;
    private ArrayList<Lutemon> battleLutemons;

    public BattleAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
        this.battleLutemons = new ArrayList<>();
        //Checking the right place and adding it to a new ArrayList
        for (Lutemon lutemon : lutemons){
            if (lutemon.getPlace() == 2){
                battleLutemons.add(lutemon);
            }
        }
        this.selectedLutemon = new HashSet<>();
    }
    @NonNull
    @Override
    public BattleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BattleViewHolder((LayoutInflater.from(context).inflate(R.layout.battle_view, parent, false)));
    }

    @Override
    public void onBindViewHolder(@NonNull BattleViewHolder holder, int position) {
        storage = Storage.getInstance();

        Lutemon lutemon = battleLutemons.get(position);
        holder.nameColor.setText(battleLutemons.get(position).getName() + " (" + battleLutemons.get(position).getColor() + ")");
        holder.itemView.setBackgroundColor(Color.RED);

        holder.itemView.setOnClickListener(view -> {
            if (selectedLutemon.contains(lutemon)){
                selectedLutemon.remove(lutemon);
                battleLutemons.get(position).setChoose(0);
                holder.itemView.setBackgroundColor(Color.RED);
            } else {
                if (selectedLutemon.size() < 2){
                    selectedLutemon.add(lutemon);
                    battleLutemons.get(position).setChoose(1);
                    holder.itemView.setBackgroundColor(Color.GREEN);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (Lutemon lutemon : lutemons){
            if (lutemon.getPlace() == 2){
                count++;
            }
        }
        return count;
    }


}
