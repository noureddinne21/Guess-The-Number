package com.example.guessnumbers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Activity_Game_Infinety extends AppCompatActivity {

    private TextView t1,btn;
    private RecyclerView recyclerView;
    private EditText input;
    private String value;

    private String num_rand;
    //ArrayAdapter<String> arr;
    ArrayList<String> list = new ArrayList<String>();

    MyAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_infinety);

        t1=findViewById(R.id.textView33);
        input=findViewById(R.id.editTextNumberSigned1);
        btn=findViewById(R.id.ngs);
        recyclerView=findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);


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
                        String put= input.getText().toString();
                        list.add("\uD83C\uDF89 Your guess of "+put+" is correct!");
                        input.setText("");

                    } else{

                        String put= input.getText().toString();

                        if (Integer.parseInt(i)>Integer.parseInt(num_rand)) {
                            list.add("\uD83C\uDF88 Your guess of "+put+" is too high!");
                        }else if (Integer.parseInt(i)<Integer.parseInt(num_rand)) {
                            list.add("⚓ Your guess of "+put+" is too low!");
                        }
                        input.setText("");

                    }

                }else {

                    Toast.makeText(Activity_Game_Infinety.this, "Pleas Put Number", Toast.LENGTH_SHORT).show();


                }

                adapter = new MyAdapter(list);
                recyclerView.setAdapter(adapter);


            }
        });




    }


    @Override
    public void onBackPressed() {

        AlertDialog d = new AlertDialog.Builder(Activity_Game_Infinety.this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i = new Intent(Activity_Game_Infinety.this, Activity_choce_game.class);
                        startActivity(i);

                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finishAffinity();

                    }
                })
                .setNeutralButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

    }

    public int random(int n){

        int random = new Random().nextInt(n)+1;

        return random ;
    }



    public void levels(String l){

        if (Integer.parseInt(l)==1){
            t1.setText("1-9");
            num_rand= String.valueOf(random(9));
        } else if (Integer.parseInt(l)==2) {
            t1.setText("1-99");
            num_rand= String.valueOf(random(99));
        } else if (Integer.parseInt(l)==3) {
            t1.setText("1-999");
            num_rand= String.valueOf(random(999));
        }

    }

}