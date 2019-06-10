package com.example.dealornodeal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CashBoard extends AppCompatActivity {

    DbHelper database;
    private ListView listView;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_board);

        listView = findViewById(R.id.cashListView);
        database = new DbHelper(this); 

        populateListView();

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Board.class);
                startIntent.putExtra("no deal", "blank");
                startActivity(startIntent);

            }
        });

    }

    public void populateListView(){
        Cursor data = database.getAllData();
        ArrayList<Case> caseList = new ArrayList<>();
        while (data.moveToNext()){
            if (data.getInt(3) == 0){
                caseList.add(new Case(data.getInt(1), data.getInt(2), data.getInt(3)));
            }
        }

        Collections.sort(caseList, new Comparator<Case>() {
            @Override
            public int compare(Case c1, Case c2) {
                return Integer.valueOf(c2.getValue()).compareTo(c1.getValue());
            }
        });

        final ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, caseList);
        listView.setAdapter(adapter);
    }
}
