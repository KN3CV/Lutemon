package com.example.lutemon;

public class MoveLutemon {

    public MoveLutemon(){}

    public void moveToBase(Lutemon lutemon){
        lutemon.setPlace(0);
        lutemon.setChoose(0);
    }

    public void moveToTrain(Lutemon lutemon){
        lutemon.setPlace(1);
        lutemon.setChoose(0);
    }

    public void moveToBattle(Lutemon lutemon){
        lutemon.setPlace(2);
        lutemon.setChoose(0);
    }
}
