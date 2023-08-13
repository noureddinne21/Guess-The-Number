package com.example.guessnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_selact extends AppCompatActivity {

    private RadioButton EASY ,MEDIUM ,HARD;
    private TextView start;
    private String value;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selact);

        EASY=findViewById(R.id.radioButton1);
        MEDIUM=findViewById(R.id.radioButton2);
        HARD=findViewById(R.id.radioButton3);

        start=findViewById(R.id.ng);

        Bundle b = getIntent().getExtras();
        if (b!=null){
            value = b.getString("type");
        }




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (EASY.isChecked()||MEDIUM.isChecked()||HARD.isChecked()){

                    if (Integer.parseInt(value)==1){

                        i =new Intent(Activity_selact.this,Activity_Game.class);

                    } else if (Integer.parseInt(value)==2) {

                        i =new Intent(Activity_selact.this,Activity_Game_Infinety.class);

                    }

                    if(EASY.isChecked()){
                    i.putExtra("level","1");
                } else if (MEDIUM.isChecked()) {
                    i.putExtra("level","2");
                }else if (HARD.isChecked()) {
                    i.putExtra("level","3");
                }
                    startActivity(i);
                }else {
                    Toast.makeText(Activity_selact.this, "Pleas Selact Difficulty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}