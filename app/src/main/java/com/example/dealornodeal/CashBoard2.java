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
import java.util.Collections;
import java.util.Comparator;

public class CashBoard2 extends AppCompatActivity {

    DbHelper database;
    private ListView listView2;
    private Button backBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_board2);

        listView2 = findViewById(R.id.cashListView2);
        database = new DbHelper(this);

        populateListView();

        backBtn2 = findViewById(R.id.backBtn2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Dealer.class);
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
        listView2.setAdapter(adapter);
    }

}
