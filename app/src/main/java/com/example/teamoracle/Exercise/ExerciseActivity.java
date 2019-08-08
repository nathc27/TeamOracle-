package com.example.teamoracle.Exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.teamoracle.DashboardActivity;
import com.example.teamoracle.R;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView btn_back;
    private List<String> topics;
    private ExerciseDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_page);
        db = new ExerciseDBHelper(this);
        db.cleanDatabase();
        topics = db.getTopics();
        recyclerView = findViewById(R.id.recyc_exercise);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ExerciseAdapter(this, topics));

        //set btn_back onClickListener
        btn_back = findViewById(R.id.btn_back_dashboard);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
