package com.example.lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText name;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
        name = findViewById(R.id.txtName);
    }

    public void addLutemon(View view){

        RadioGroup rgLutemons = findViewById(R.id.rgLutemons);
        //Adding the right lutemon based on the radio button chosen
        switch (rgLutemons.getCheckedRadioButtonId()){
            case R.id.rbWhite:
                Storage.getInstance().addLutemon(new Lutemon(name.getText().toString(), "white", 5, 4, 0, 20, 20, id++, 0, 0, 0,R.drawable.lutew, 0));
                break;

            case R.id.rbGreen:
                Storage.getInstance().addLutemon(new Lutemon(name.getText().toString(), "green", 6, 3, 0, 19, 19, id++, 0, 0,0, R.drawable.luteg, 0));
                break;

            case R.id.rbPink:
                Storage.getInstance().addLutemon(new Lutemon(name.getText().toString(), "pink", 7, 2, 0, 18, 18, id++, 0, 0, 0, R.drawable.lutep, 0));
                break;

            case R.id.rbOrange:
                Storage.getInstance().addLutemon(new Lutemon(name.getText().toString(), "orange", 8, 1, 0, 17, 17, id++, 0, 0, 0, R.drawable.luteo, 0));
                break;

            case R.id.rbBlack:
                Storage.getInstance().addLutemon(new Lutemon(name.getText().toString(), "black", 9, 0, 0, 16, 16, id++, 0, 0, 0, R.drawable.luteb, 0));
                break;
        }
    }
}
