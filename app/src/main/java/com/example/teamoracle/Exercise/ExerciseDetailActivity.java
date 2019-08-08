package com.example.teamoracle.Exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamoracle.R;

import java.util.List;
import java.util.Queue;

public class ExerciseDetailActivity extends AppCompatActivity {
    private TextView tv_question;
    private TextView tv_answer;
    private EditText et_answer;
    private Button bt_submit;
    private ImageView bt_next;
    private ExerciseDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        tv_question = findViewById(R.id.tv_ec_question);
        tv_answer = findViewById(R.id.tv_ec_answer);
        et_answer = findViewById(R.id.ec_answer);
        bt_submit = findViewById(R.id.btn_ec_submit);
        bt_next = findViewById(R.id.btn_next_e);
        //get exercises from db
        String topic = this.getIntent().getStringExtra(Exercise.EXERCISE_TAG);
        db = new ExerciseDBHelper(this);
        final Queue<Exercise> exercises = db.getExerciseByTopic(topic);
        //set first question
        Exercise e = exercises.poll();
        resetPage(e);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exercise e = exercises.poll();
                tv_answer.setText("");
                if (e != null) {
                    resetPage(e);
                } else {
                    Toast.makeText(ExerciseDetailActivity.this, "You hava completed all exercises for this module. Wooohooo!", Toast.LENGTH_LONG);
                    ExerciseDetailActivity.this.onStop();
                }
            }
        });
    }

    private void resetPage(Exercise e) {
        final Exercise ex = e;
        tv_answer.setText("");
        tv_question.setText(e.getQuestion());
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_answer.setText("");
                tv_answer.setText(ex.getAnswer());
            }
        });
    }


}

