package com.example.teamoracle.Leaderboard;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.teamoracle.R;
import com.example.teamoracle.Quiz.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;

public class LeaderboardActivity extends AppCompatActivity {
    AlertDialog dialog;
    private LeaderboardAdapter adapter;
    RecyclerView recyclerView;
    private List<User> userList;
    private TextView playerScore;
    private String uid;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        /*dialog = new SpotsDialog.Builder().setContext(this).build();
        dialog.show();
        recyclerView = findViewById(R.id.leaderboard_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        userList = new ArrayList<>();
        adapter = new LeaderboardAdapter(userList, this);
        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = auth.getCurrentUser();
        uid = user.getUid();

        TextView name = findViewById(R.id.title);
        TextView total = findViewById(R.id.score);
        playerScore = findViewById(R.id.playerScore);

        showScores(uid);

        // Query & ValueEventListener reference - https://www.youtube.com/watch?v=WeoryL3XyA4
        Query order = FirebaseDatabase.getInstance().getReference("User").orderByChild("total").limitToFirst(10);
        order.addListenerForSingleValueEvent(valueEventListener);

        recyclerView.setAdapter(adapter);

        return rootView;*/
    }

    // Populates the leaderboard RecyclerView
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    User users = ds.getValue(User.class);
                    userList.add(users);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    // Sums the scores of a player's results
    private void showScores(String uid) {
        DatabaseReference questionScore = FirebaseDatabase.getInstance().getReference();
        questionScore.child("User").child(uid).child("test").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long total = 0;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    long value = ds.getValue(Long.class);
                    total = total + value;
                }
                dataSnapshot.getRef().getParent().child("total").setValue(total);
                playerScore.setText(String.valueOf(total));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
