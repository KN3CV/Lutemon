package com.example.lutemon;

public class TrainingArea {

    public TrainingArea(){
    }

    public void train(Lutemon lutemon){
        lutemon.setExperience(lutemon.getExperience() + 1);
    }
}
