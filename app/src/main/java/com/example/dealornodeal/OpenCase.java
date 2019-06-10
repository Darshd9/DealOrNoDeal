package com.example.dealornodeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OpenCase extends AppCompatActivity {

    private TextView cashTextView;
    DbHelper database;
    private String caseValue;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_case);

        cashTextView = findViewById(R.id.cashTextView);
        nextBtn = findViewById(R.id.nextBtn);

        database = new DbHelper(this);

        Intent recievedIntent = getIntent();

        caseValue = recievedIntent.getStringExtra("cash");

        String money = "$" + caseValue;

        cashTextView.setText(money);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(OpenCase.this, Board.class);
                startIntent.putExtra("no deal", "blank");
                startActivity(startIntent);
            }
        });

    }
}
