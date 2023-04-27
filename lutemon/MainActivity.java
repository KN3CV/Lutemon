package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void switchToAddLutemon(View view){
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToBase(View view){
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToTrain(View view){
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }
    public void switchToBattle(View view){
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }
}