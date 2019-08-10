package com.example.teamoracle.Leaderboard;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Quiz.User;
import com.example.teamoracle.R;
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


public class LeaderboardFragment extends Fragment {
    AlertDialog dialog;
    private LeaderboardAdapter adapter;
    RecyclerView recyclerView;
    private List<User> userList;
    private TextView playerScore;
    private String uid;
    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        dialog = new SpotsDialog.Builder().setContext(getContext()).build();
        dialog.show();
        recyclerView = rootView.findViewById(R.id.hubRV);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        userList = new ArrayList<>();
        adapter = new LeaderboardAdapter(userList, this.getContext());

        auth = FirebaseAuth.getInstance();
        final FirebaseUser user = auth.getCurrentUser();
        uid = user.getUid();

        TextView name = rootView.findViewById(R.id.title);
        TextView total = rootView.findViewById(R.id.score);
        playerScore = rootView.findViewById(R.id.playerScore);

        showScores(uid);

        // Query & ValueEventListener reference - https://www.youtube.com/watch?v=WeoryL3XyA4
        Query order = FirebaseDatabase.getInstance().getReference("User").orderByChild("total").limitToFirst(10);
        order.addListenerForSingleValueEvent(valueEventListener);

        recyclerView.setAdapter(adapter);

        return rootView;
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