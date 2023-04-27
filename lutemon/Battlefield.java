package com.example.lutemon;

import android.content.Context;

import java.util.ArrayList;

public class Battlefield {

    private Context context;

    public Battlefield(){}


    public void fight(ArrayList<Lutemon> fightList){
        //Getting the chosen Lutemons
        Lutemon fighterA = fightList.get(0);
        Lutemon fighterB = fightList.get(1);
        Lutemon fighterC = new Lutemon();


        int damage = fighterA.getAttack() + fighterA.getExperience() - fighterB.getDefense();
        fighterB.setHealth(fighterB.getHealth() - damage);
        //Checking if the Lutemon is alive and changing stats
        if (fighterB.getHealth() > 0) {
            fighterC.setHealth(fighterA.getHealth());
            fighterC.setAttack(fighterA.getAttack());
            fighterC.setMaxHealth(fighterA.getMaxHealth());
            fighterC.setExperience(fighterA.getExperience());
            fighterC.setId(fighterA.getId());
            fighterC.setDefense(fighterA.getDefense());
            fighterC.setChoose(fighterA.getChoose());
            fighterC.setColor(fighterA.getColor());
            fighterC.setName(fighterA.getName());
            fighterC.setWins(fighterA.getWins());
            fighterC.setLosses(fighterA.getLosses());
            fighterC.setImage(fighterA.getImage());
            fighterA.setHealth(fighterB.getHealth());
            fighterA.setAttack(fighterB.getAttack());
            fighterA.setMaxHealth(fighterB.getMaxHealth());
            fighterA.setExperience(fighterB.getExperience());
            fighterA.setId(fighterB.getId());
            fighterA.setDefense(fighterB.getDefense());
            fighterA.setChoose(fighterB.getChoose());
            fighterA.setColor(fighterB.getColor());
            fighterA.setName(fighterB.getName());
            fighterA.setWins(fighterB.getWins());
            fighterA.setLosses(fighterB.getLosses());
            fighterA.setImage(fighterB.getImage());
            fighterB.setHealth(fighterC.getHealth());
            fighterB.setAttack(fighterC.getAttack());
            fighterB.setMaxHealth(fighterC.getMaxHealth());
            fighterB.setExperience(fighterC.getExperience());
            fighterB.setId(fighterC.getId());
            fighterB.setDefense(fighterC.getDefense());
            fighterB.setChoose(fighterC.getChoose());
            fighterB.setColor(fighterC.getColor());
            fighterB.setName(fighterC.getName());
            fighterB.setWins(fighterC.getWins());
            fighterB.setLosses(fighterC.getLosses());
            fighterB.setImage(fighterC.getImage());
        //If the Lutemon died adding experience, win, loss and resetting health
        if(fighterB.getHealth() <= 0) {
            fighterA.setExperience(fighterA.getExperience() + 1);
            fighterA.setHealth(fighterA.getMaxHealth());
            fighterA.setWins(fighterA.getWins() + 1);
            fighterB.setHealth(fighterB.getMaxHealth());
            fighterB.setLosses(fighterB.getLosses() + 1);
            fighterA.setPlace(0);
            fighterB.setPlace(0);
        }
}}
    public void setStats(ArrayList<Lutemon> fightList){
        //Just in case setting the stats to correct ones if the earlier didn't work
        Lutemon fighterA = fightList.get(0);
        Lutemon fighterB = fightList.get(1);
        fighterA.setExperience(fighterA.getExperience() + 1);
        fighterA.setHealth(fighterA.getMaxHealth());
        fighterA.setWins(fighterA.getWins() + 1);
        fighterB.setHealth(fighterB.getMaxHealth());
        fighterB.setLosses(fighterB.getLosses() + 1);
        fighterA.setPlace(0);
        fighterB.setPlace(0);
    }
}
