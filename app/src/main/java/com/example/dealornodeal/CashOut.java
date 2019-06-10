package com.example.dealornodeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CashOut extends AppCompatActivity {

    private TextView prizeMoneyTV, ownCaseTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_out);

        prizeMoneyTV = findViewById(R.id.prizeMoneyTV);
        ownCaseTV = findViewById(R.id.ownCaseTV);

        Intent recievedIntent = getIntent();

        String prizeMoney = recievedIntent.getStringExtra("money");
        String ownCase = recievedIntent.getStringExtra("ownCase");

        prizeMoneyTV.setText(prizeMoney);
        ownCaseTV.setText(ownCase);

    }
}
