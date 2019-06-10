package com.example.dealornodeal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dealer extends AppCompatActivity {

    DbHelper database;
    private Button dealBtn, noDealBtn, cashBoardBtn2;
    private TextView dealTextView;
    private String ownCaseValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer);

        database = new DbHelper(this);

        dealBtn = findViewById(R.id.dealBtn);
        noDealBtn = findViewById(R.id.noDealBtn);
        dealTextView = findViewById(R.id.dealTextView);
        cashBoardBtn2 = findViewById(R.id.cashBoardBtn2);

        Intent recievedIntent = getIntent();
        ownCaseValue = recievedIntent.getStringExtra("ownCase");

        final String money = "$" + calculateDeal();

        toastMessage("Deal or No Deal?");

        dealTextView.setText(money);

        dealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Dealer.this, CashOut.class);
                startIntent.putExtra("money", money);
                startIntent.putExtra("ownCase", ownCaseValue);
                startActivity(startIntent);
            }
        });

        noDealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(Dealer.this, Board.class);
                startIntent.putExtra("no deal", "noDeal");
                startActivity(startIntent);
            }
        });

        cashBoardBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getApplicationContext(), CashBoard2.class);
                startActivity(start);
            }
        });

    }

    private int calculateDeal(){
        int count = 0;
        int sum = 0;
        Cursor data = database.getAllData();
        while (data.moveToNext()){
            if (data.getInt(3) == 0){
                count++;
                sum += data.getInt(2);
            }
        }
        int average = sum/count;
        return average;
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
