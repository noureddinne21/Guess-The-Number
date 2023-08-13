package com.example.guessnumbers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Activity_Game extends AppCompatActivity {

    private TextView t1,t2,t3,btn;
    private EditText input;
    private String value;
    private int c1 = 3 ;
    private int c2 = 6 ;
    private int c3 = 10 ;
    private int c ;
    private int g = 0 ;

    private String num_rand;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        t1=findViewById(R.id.textView3);
        t2=findViewById(R.id.textView6);
        t3=findViewById(R.id.textView5);
        input=findViewById(R.id.editTextNumberSigned);
        btn=findViewById(R.id.ng);

        Bundle b = getIntent().getExtras();
        if (b!=null){
            value = b.getString("level");
        }

        levels(value);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = String.valueOf(input.getText());
                if (!i.isEmpty()){

                    if (Integer.parseInt(i)==Integer.parseInt(num_rand)){

                        levels(value);

                        t2.setText(String.valueOf(c));
                        input.setText("");

                        Toast.makeText(Activity_Game.this, "Yippie You Win!!\uD83D\uDE0D\uD83D\uDE0D", Toast.LENGTH_SHORT).show();
                        //t3.setText("Yippie You Win!!\uD83D\uDE0D\uD83D\uDE0D");


                    } else{

                        c-=1;
                        g+=1;
                        String put= input.getText().toString();
                        list.add(put);

                        input.setText("");
                        t2.setText(String.valueOf(c));

                        if (Integer.parseInt(i)>Integer.parseInt(num_rand)) {

                            Toast.makeText(Activity_Game.this, "Your guess is too high.\uD83D\uDE32", Toast.LENGTH_SHORT).show();
                            //t3.setText("Your guess is too high.\uD83D\uDE32");

                        }else if (Integer.parseInt(i)<Integer.parseInt(num_rand)) {

                            Toast.makeText(Activity_Game.this, "Your guess is too low.\uD83D\uDE2A", Toast.LENGTH_SHORT).show();
                            t3.setText("Your guess is too low.\uD83D\uDE2A");

                        }

                        if (c==0){
                            AlertDialog d = new AlertDialog.Builder(Activity_Game.this)
                                    .setTitle("Faild")
                                    .setMessage("You Not guessed it guesses "+list)
                                    .setCancelable(false)
                                    .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            Intent i = new Intent(Activity_Game.this, Activity_choce_game.class);
                                            startActivity(i);

                                        }
                                    })
                                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                            finishAffinity();

                                        }
                                    }).show();

                        }

                    }

                }else {

                    Toast.makeText(Activity_Game.this, "Pleas Put Number", Toast.LENGTH_SHORT).show();


                }


            }
        });




    }





    public int random(int n){

        int random = new Random().nextInt(n)+1;

        return random ;
    }



    public void levels(String l){

        if (Integer.parseInt(l)==1){
            t1.setText("1-9");
            c=c1;
            t2.setText(String.valueOf(c));
            num_rand= String.valueOf(random(9));
        } else if (Integer.parseInt(l)==2) {
            t1.setText("1-99");
            c=c2;
            t2.setText(String.valueOf(c));
            num_rand= String.valueOf(random(99));
        } else if (Integer.parseInt(l)==3) {
            t1.setText("1-999");
            c=c3;
            t2.setText(String.valueOf(c));
            num_rand= String.valueOf(random(999));
        }

    }













}