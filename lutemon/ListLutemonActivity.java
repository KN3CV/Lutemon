package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class ListLutemonActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;
    private MoveLutemon moveLutemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemon);

        storage = Storage.getInstance();


        Button moveLutemons = findViewById(R.id.btnMoveFromBase);
        RadioGroup rgMove = findViewById(R.id.rgMoveFromBase);
        recyclerView = findViewById(R.id.rvLutemon);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListLutemonAdapter(getApplicationContext(), storage.getLutemon()));

        moveLutemons.setOnClickListener(view -> {
            moveLutemon = new MoveLutemon();
            storage = Storage.getInstance();
            ArrayList<Lutemon> lutemons = storage.getLutemon();
            for (Lutemon lutemon : lutemons) {
                if (lutemon.getChoose() == 1) {
                    switch (rgMove.getCheckedRadioButtonId()){
                        case R.id.rbKeepBase:
                            moveLutemon.moveToBase(lutemon);
                            break;
                        case R.id.rbMoveTrain:
                            moveLutemon.moveToTrain(lutemon);
                            break;
                        case R.id.rbMoveBattle:
                            moveLutemon.moveToBattle(lutemon);
                            break;
                        default:
                            moveLutemon.moveToBase(lutemon);
                    }
                }
            }
            finish();
        });
    }
}