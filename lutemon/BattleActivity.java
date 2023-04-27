package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Set;

public class BattleActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;
    private MoveLutemon moveLutemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvBattleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new BattleAdapter(getApplicationContext(), storage.getLutemon()));
        Button moveLutemons = findViewById(R.id.btnMoveFromBattle);
        Button battleFragment = findViewById(R.id.btnStartFight);

        battleFragment.setOnClickListener(listener);

        moveLutemons.setOnClickListener(view -> {
            moveLutemon = new MoveLutemon();
            storage = Storage.getInstance();
            RadioGroup rgMove = findViewById(R.id.rgMoveFromBattle);
            ArrayList<Lutemon> lutemons = storage.getLutemon();
            for (Lutemon lutemon : lutemons) {
                if (lutemon.getChoose() == 1) {
                    switch (rgMove.getCheckedRadioButtonId()){
                        case R.id.rbKeepBattle:
                            moveLutemon.moveToBattle(lutemon);
                            break;
                        case R.id.rbMoveTrainFromBattle:
                            moveLutemon.moveToTrain(lutemon);
                            break;
                        case R.id.rbMoveBaseFromBattle:
                            moveLutemon.moveToBase(lutemon);
                            break;
                        default:
                            moveLutemon.moveToBattle(lutemon);
                    }
                }
            }
            finish();
        });
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;
            switch (view.getId()) {
                case R.id.btnStartFight:
                    fragment = new BattleFragment();
                    break;
                default:
                    fragment = new BattleFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
    };
}
