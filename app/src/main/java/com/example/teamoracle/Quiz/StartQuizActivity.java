package com.example.teamoracle.Quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.teamoracle.R;

public class StartQuizActivity extends AppCompatActivity {

    private Button start;
    private Button back;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String card = (String) extras.get("card");

            // Converts cardID's into numbers
            if (card != null) {
                switch (card) {
                    case "T1":
                        number = 0;
                        break;
                    case "T2":
                        number = 10;
                        break;
                    case "T3":
                        number = 20;
                        break;
                    case "T4":
                        number = 30;
                        break;
                    case "T5":
                        number = 40;
                        break;
                    case "T6":
                        number = 50;
                        break;
                    case "T7":
                        number = 60;
                        break;
                    case "T8":
                        number = 70;
                        break;
                    case "T9":
                        number = 80;
                        break;
                    default:
                        number = 90;
                        break;
                }
            }

            start = findViewById(R.id.startButton);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(StartQuizActivity.this, TestActivity.class);
                    intent.putExtra("number", number);
                    startActivity(intent);
                }
            });
            back = findViewById(R.id.goBackButton);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }
}
