package com.example.teamoracle.Quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.teamoracle.Leaderboard.LeaderboardAdapter;
import com.example.teamoracle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private QuizAdapter adapter;
    RecyclerView recyclerView;
    private List<Topics> topicsList;
    private TextView topic;
    private String topicid;
    private FirebaseAuth auth;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        topicsList = new ArrayList<>();

        FirebaseOptions optionsQuiz = new FirebaseOptions.Builder()
                .setApplicationId("1:223161578592:android:8c9b9bfc66f08c97")
                .setApiKey("AIzaSyDLVzKvVVMhpT31QigtguQSUa4mbrAoKGI")
                .setDatabaseUrl("https://your-second-database.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(this , optionsQuiz, "Topics");
        FirebaseApp secondApp = FirebaseApp.getInstance("second_database_name");
        reference = FirebaseDatabase.getInstance();




    }
}
