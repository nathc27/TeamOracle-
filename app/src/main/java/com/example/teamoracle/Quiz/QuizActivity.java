package com.example.teamoracle.Quiz;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamoracle.Leaderboard.LeaderboardAdapter;
import com.example.teamoracle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

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
        topicsList = new ArrayList<Topics>();

        FirebaseOptions optionsQuiz = new FirebaseOptions.Builder()
                .setApplicationId("1:223161578592:android:8c9b9bfc66f08c97")
                .setApiKey("AIzaSyDLVzKvVVMhpT31QigtguQSUa4mbrAoKGI")
                .setDatabaseUrl("https://quizdata-21388.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(this , optionsQuiz, "Topics");

        reference = FirebaseDatabase.getInstance().getReference().child("Topics");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Topics> topicsList = new ArrayList<>();
               for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Topics t = dataSnapshot1.getValue(Topics.class);
                    topicsList.add(t);
                }
               adapter = new QuizAdapter(QuizActivity.this,topicsList);
               recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }
}
