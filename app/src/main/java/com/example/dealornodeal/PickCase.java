package com.example.dealornodeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PickCase extends AppCompatActivity {

    private TextView pickCaseTitle, pickCaseNum;
    DbHelper database;
    private String caseNum;
    private Button nextBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_case);

        pickCaseTitle = findViewById(R.id.pickCaseTitle);
        pickCaseNum = findViewById(R.id.pickCaseNum);
        nextBtn2 = findViewById(R.id.nextBtn2);

        database = new DbHelper(this);

        Intent recievedIntent = getIntent();

        caseNum = recievedIntent.getStringExtra("caseNum");


        pickCaseNum.setText(caseNum);

        nextBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(PickCase.this, Board.class);
                startIntent.putExtra("no deal", "blank");
                startActivity(startIntent);
            }
        });

    }
}
