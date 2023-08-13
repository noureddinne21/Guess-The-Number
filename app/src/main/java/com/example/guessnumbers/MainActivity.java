package com.example.guessnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private int t = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);


        new CountDownTimer(4500, 200) {
            @Override
            public void onTick(long millisUntilFinished) {


                switch (t) {
                    case 1:
                        textView.setText("G_");
                        t+=1;
                        break;
                    case 2:
                        textView.setText("Gu_");
                        t+=1;
                        break;
                    case 3:
                        textView.setText("Gue_");
                        t+=1;
                        break;
                    case 4:
                        textView.setText("Gues_");
                        t+=1;
                        break;
                    case 5:
                        textView.setText("Guess_");
                        t+=1;
                        break;
                    case 6:
                        textView.setText("Guess _");
                        t+=1;
                        break;
                    case 7:
                        textView.setText("Guess T_");
                        t+=1;
                        break;
                    case 8:
                        textView.setText("Guess Th_");
                        t+=1;
                        break;
                    case 9:
                        textView.setText("Guess The_");
                        t+=1;
                        break;
                    case 10:
                        textView.setText("Guess The _");
                        t+=1;
                        break;
                    case 11:
                        textView.setText("Guess The N_");
                        t+=1;
                        break;
                    case 12:
                        textView.setText("Guess The Nu_");
                        t+=1;
                        break;
                    case 13:
                        textView.setText("Guess The Num_");
                        t+=1;
                        break;
                    case 14:
                        textView.setText("Guess The Numb_");
                        t+=1;
                        break;
                    case 15:
                        textView.setText("Guess The Numbe_");
                        t+=1;
                        break;
                    case 16:
                        textView.setText("Guess The Number_");
                        t+=1;
                        break;
                    case 17:
                        textView.setText("Guess The Numbers");
                        t+=1;
                        break;


                }


            }

            @Override
            public void onFinish() {

                Intent i = new Intent(MainActivity.this,Activity_choce_game.class);
                startActivity(i);

            }
        }.start();
    }
}