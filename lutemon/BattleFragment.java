package com.example.lutemon;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;


public class BattleFragment extends Fragment {

    private Battlefield battlefield;
    private Storage storage;
    public BattleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle, container, false);
        battlefield = new Battlefield();
        TextView statsA = view.findViewById(R.id.txtvStatsA);
        TextView statsB = view.findViewById(R.id.txtvStatsB);
        TextView fightStats = view.findViewById(R.id.txtvFight);
        ImageView imageA = view.findViewById(R.id.ivLutA);
        ImageView imageB = view.findViewById(R.id.ivLutB);
        Button attack = view.findViewById(R.id.btnBattleAttack);
        ArrayList<Lutemon> fightList = new ArrayList<>();
        storage = Storage.getInstance();
        ArrayList<Lutemon> lutemons = storage.getLutemon();
        for (Lutemon lutemon : lutemons){
            if (lutemon.getChoose() == 1){
                fightList.add(lutemon);
                lutemon.setChoose(0);
            }
        }
        Lutemon fighterA = fightList.get(0);
        Lutemon fighterB = fightList.get(1);
        statsA.setText(fighterA.getName() + " (" + fighterA.getColor() + ")\nAttack" + fighterA.getAttack() + "\nDefense" + fighterA.getDefense() + "\nExperience" + fighterA.getExperience() + "\nHealth" + fighterA.getHealth() + "/" + fighterA.getMaxHealth());
        statsB.setText(fighterB.getName() + " (" + fighterB.getColor() + ")\nAttack" + fighterB.getAttack() + "\nDefense" + fighterB.getDefense() + "\nExperience" + fighterB.getExperience() + "\nHealth" + fighterB.getHealth() + "/" + fighterB.getMaxHealth());
        imageA.setImageResource(fighterA.getImage());
        imageB.setImageResource(fighterB.getImage());
        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                battlefield.fight(fightList);
                fightStats.setText(fighterA.getName() + " (" + fighterA.getColor() + ") attacked " + fighterB.getName() + " (" + fighterB.getColor() + ") for " + (fighterA.getAttack() + fighterA.getExperience()));
                if (fighterB.getHealth() > 0) {

                   statsA.setText(fighterA.getName() + " (" + fighterA.getColor() + ")\nAttack " + fighterA.getAttack() + "\nDefense " + fighterA.getDefense() + "\nExperience " + fighterA.getExperience() + "\nHealth " + fighterA.getHealth() + "/" + fighterA.getMaxHealth());
                    statsB.setText(fighterB.getName() + " (" + fighterB.getColor() + ")\nAttack " + fighterB.getAttack() + "\nDefense " + fighterB.getDefense() + "\nExperience " + fighterB.getExperience() + "\nHealth " + fighterB.getHealth() + "/" + fighterB.getMaxHealth());
                    imageA.setImageResource(fighterA.getImage());
                    imageB.setImageResource(fighterB.getImage());
                    if (attack.getText().equals("Attack")) {
                        attack.setText("Defend");
                    } else {
                        attack.setText("Attack");
                    }}
                    if(fighterB.getHealth() <= 0) {
                        battlefield.setStats(fightList);
                        Toast.makeText(getContext().getApplicationContext(), fighterB.getName() + " (" + fighterB.getColor() + ") lost", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
            }
        });
        return view;
        }
    }