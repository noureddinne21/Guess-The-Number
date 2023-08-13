package com.example.guessnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Activity_choce_game extends AppCompatActivity {

    private TextView b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choce_game);

        b1=findViewById(R.id.ng);
        b2=findViewById(R.id.ig);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Activity_choce_game.this,Activity_selact.class);
                i.putExtra("type","1");
                startActivity(i);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Activity_choce_game.this,Activity_selact.class);
                i.putExtra("type","2");
                startActivity(i);

            }
        });

    }
}