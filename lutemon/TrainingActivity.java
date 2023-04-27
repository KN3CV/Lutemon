package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class TrainingActivity extends AppCompatActivity {
    private Storage storage;
    private TrainingArea trainingArea;
    private RecyclerView recyclerView;
    private MoveLutemon moveLutemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        storage = Storage.getInstance();
        Button moveLutemons = findViewById(R.id.btnMoveFromTrain);
        Button trainLutemons = findViewById(R.id.btnTrainLut);
        recyclerView = findViewById(R.id.rvTrainList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TrainingAdapter(getApplicationContext(), storage.getLutemon()));

        moveLutemons.setOnClickListener(view -> {
            RadioGroup rgMove = findViewById(R.id.rgMoveFromTrain);
            moveLutemon = new MoveLutemon();
            storage = Storage.getInstance();
            ArrayList<Lutemon> lutemons = storage.getLutemon();
            for (Lutemon lutemon : lutemons) {
                if (lutemon.getChoose() == 1) {
                    switch (rgMove.getCheckedRadioButtonId()) {
                        case R.id.rbKeepTrain:
                            moveLutemon.moveToTrain(lutemon);
                            break;
                        case R.id.rbMoveBattleFromTrain:
                            moveLutemon.moveToBattle(lutemon);
                            break;
                        case R.id.rbMoveBaseFromTrain:
                            moveLutemon.moveToBase(lutemon);
                            break;
                        default:
                            moveLutemon.moveToTrain(lutemon);
                    }
                }
            }
            finish();
        });

        trainLutemons.setOnClickListener(view -> {
            trainingArea = new TrainingArea();
            storage = Storage.getInstance();
            ArrayList<Lutemon> lutemons = storage.getLutemon();
            for (Lutemon lutemon : lutemons) {
                if (lutemon.getChoose() == 1) {
                    if (lutemon.getExperience() < 10) {
                        trainingArea.train(lutemon);
                        Toast.makeText(getApplicationContext(), lutemon.getName() + " (" + lutemon.getColor() + ") gained experience", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), lutemon.getName() + " (" + lutemon.getColor() + ") has max experience", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}

