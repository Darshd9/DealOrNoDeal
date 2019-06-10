package com.example.dealornodeal;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DbHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new DbHelper(this);

        Button playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.clearData();
                createBoard();
                Intent startIntent = new Intent(MainActivity.this, Board.class);
                startIntent.putExtra("no deal", "blank");
                startActivity(startIntent);
            }
        });

        createBoard();
    }

    public void createBoard() {
        ArrayList<Integer> cash = new ArrayList<>();//5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000
        cash.add(1);
        cash.add(5);
        cash.add(10);
        cash.add(25);
        cash.add(50);
        cash.add(75);
        cash.add(100);
        cash.add(200);
        cash.add(400);
        cash.add(500);
        cash.add(750);
        cash.add(1000);
        cash.add(5000);
        cash.add(10000);
        cash.add(25000);
        cash.add(50000);
        cash.add(75000);
        cash.add(100000);
        cash.add(200000);
        cash.add(300000);
        cash.add(400000);
        cash.add(500000);
        cash.add(750000);
        cash.add(1000000);
        Collections.shuffle(cash);
        int num = 0;
        for (int i = 0; i < cash.size(); i++){
            num++;
            database.addCase(num,cash.get(i));
        }
        //Toast.makeText(this, "database created",Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "database created",Toast.LENGTH_SHORT).show();
    }
}



