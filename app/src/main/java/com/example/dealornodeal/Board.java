package com.example.dealornodeal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Board extends AppCompatActivity {

    DbHelper database;

    private Button cashBoardBtn;
    private Button case1;
    private Button case2;
    private Button case3;
    private Button case4;
    private Button case5;
    private Button case6;
    private Button case7;
    private Button case8;
    private Button case9;
    private Button case10;
    private Button case11;
    private Button case12;
    private Button case13;
    private Button case14;
    private Button case15;
    private Button case16;
    private Button case17;
    private Button case18;
    private Button case19;
    private Button case20;
    private Button case21;
    private Button case22;
    private Button case23;
    private Button case24;

    private Button pickCaseBtn;

    private int playerTurn;
    private int pickCasenum;

    private Button[] buttons;

    private ArrayList<Case> cases;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        cashBoardBtn = findViewById(R.id.cashBoardBtn);
        pickCaseBtn = findViewById(R.id.pickCaseBtn);
        case1 = findViewById(R.id.case1);
        case2 = findViewById(R.id.case2);
        case3 = findViewById(R.id.case3);
        case4 = findViewById(R.id.case4);
        case5 = findViewById(R.id.case5);
        case6 = findViewById(R.id.case6);
        case7 = findViewById(R.id.case7);
        case8 = findViewById(R.id.case8);
        case9 = findViewById(R.id.case9);
        case10 = findViewById(R.id.case10);
        case11 = findViewById(R.id.case11);
        case12 = findViewById(R.id.case12);
        case13 = findViewById(R.id.case13);
        case14 = findViewById(R.id.case14);
        case15 = findViewById(R.id.case15);
        case16 = findViewById(R.id.case16);
        case17 = findViewById(R.id.case17);
        case18 = findViewById(R.id.case18);
        case19 = findViewById(R.id.case19);
        case20 = findViewById(R.id.case20);
        case21 = findViewById(R.id.case21);
        case22 = findViewById(R.id.case22);
        case23 = findViewById(R.id.case23);
        case24 = findViewById(R.id.case24);

        database = new DbHelper(this);

        buttons = new Button[]{case1,case2,case3,case4,case5,case6, case7, case8, case9, case10, case11, case12, case13, case14, case15, case16, case17, case18, case19, case20, case21, case22, case23, case24};

        cases = new ArrayList<>();
        Cursor data = database.getAllData();
        while (data.moveToNext()){
            cases.add(new Case(data.getInt(1), data.getInt(2), data.getInt(3)));
        }

        playerTurn = 0;

        Intent check = getIntent();
        if (check.getStringExtra("no deal").equals("noDeal")){
            playerTurn++;
        }

        createBoard();

        if (playerTurn == 7 || playerTurn == 12 || playerTurn == 16 || playerTurn == 19 || playerTurn == 21 || playerTurn == 22 || playerTurn == 24){
            Intent startIntent = new Intent(Board.this, Dealer.class);
            startIntent.putExtra("ownCase", "$" + cases.get(pickCasenum).getValue());
            startActivity(startIntent);
        }

        if (playerTurn > 0) {

            toastMessage("Pick a Case");
            cashBoardBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startIntent = new Intent(getApplicationContext(), CashBoard.class);
                    startActivity(startIntent);
                }
            });

            case1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openCase(case1, 0);
                }
            });

            case2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case2, 1);

                }
            });

            case3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case3, 2);

                }
            });

            case4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case4, 3);

                }
            });

            case5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case5, 4);

                }
            });

            case6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case6, 5);

                }
            });

            case7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case7, 6);

                }
            });

            case8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case8, 7);

                }
            });

            case9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case9, 8);

                }
            });

            case10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case10, 9);

                }
            });

            case11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case11, 10);

                }
            });

            case12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case12, 11);

                }
            });

            case13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case13, 12);

                }
            });

            case14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case14, 13);

                }
            });

            case15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case15, 14);

                }
            });

            case16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case16, 15);

                }
            });

            case17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case17, 16);

                }
            });

            case18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case18, 17);

                }
            });

            case19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case19, 18);

                }
            });

            case20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case20, 19);

                }
            });

            case21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case21, 20);

                }
            });

            case22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case22, 21);

                }
            });

            case23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case23, 22);

                }
            });

            case24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openCase(case24, 23);

                }
            });
        } else {
            toastMessage("Pick your own case: ");
            case1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("1", case1, 0);

                }
            });

            case2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("2", case2, 1);
                }
            });

            case3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("3", case3, 2);

                }
            });

            case4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("4", case4, 3);

                }
            });

            case5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("5", case5, 4);

                }
            });

            case6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("6", case6, 5);

                }
            });

            case7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("7", case7, 6);

                }
            });

            case8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("8", case8, 7);

                }
            });

            case9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("9", case9, 8);

                }
            });

            case10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("10", case10, 9);

                }
            });

            case11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("11", case11, 10);

                }
            });

            case12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("12", case12, 11);

                }
            });

            case13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("13", case13, 12);

                }
            });

            case14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("14", case14, 13);

                }
            });

            case15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("15", case15, 14);

                }
            });

            case16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("16", case16, 15);

                }
            });

            case17.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("17", case17, 16);

                }
            });

            case18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("18", case18, 17);

                }
            });

            case19.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("19", case19, 18);

                }
            });

            case20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("20", case20, 19);

                }
            });

            case21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("21", case21, 20);

                }
            });

            case22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("22", case22, 21);
                }
            });

            case23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("23", case23, 22);

                }
            });

            case24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    pickCase("24", case24, 23);

                }
            });

        }


    }

    private void pickCase(String num, Button button, int caseNum){
        pickCaseBtn.setText(num);
        button.setEnabled(false);
        button.setVisibility(View.INVISIBLE);
        cases.get(caseNum).setStatus(2);
        database.updateData(cases.get(caseNum));
        Intent caseValue = new Intent(Board.this, PickCase.class);
        caseValue.putExtra("caseNum", num);
        startActivity(caseValue);


    }

    private void createBoard(){

        for (int i = 0; i < buttons.length; i++){
            if (cases.get(i).getStatus() == 1){
                buttons[i].setEnabled(false);
                buttons[i].setVisibility(View.INVISIBLE);
                playerTurn++;
            }
            if (cases.get(i).getStatus() == 2){
                buttons[i].setEnabled(false);
                buttons[i].setVisibility(View.INVISIBLE);
                int temp = i + 1;
                pickCaseBtn.setText("" + temp);
                pickCasenum = i;
                playerTurn++;
            }
        }

    }

    private void openCase(Button button, int num){
        button.setEnabled(false);
        button.setVisibility(View.INVISIBLE);
        cases.get(num).setStatus(1);
        database.updateData(cases.get(num));
        String cash = cases.get(num).getValue() + "";
        Intent caseValue = new Intent(Board.this, OpenCase.class);
        caseValue.putExtra("cash", cash);
        startActivity(caseValue);

    }




    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
