package com.example.teamoracle.Quiz;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.teamoracle.Quiz.Adapter.VerticalAdapter;
import com.example.teamoracle.Quiz.Interface.FirebaseLoadListener;
import com.example.teamoracle.R;
import com.google.firebase.FirebaseApp;
import com.example.teamoracle.Quiz.TopicCards;
import com.example.teamoracle.Quiz.Topics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;


public class QuizFragment extends Fragment implements FirebaseLoadListener {
    AlertDialog dialog;
    RecyclerView rvQuiz;
    FirebaseLoadListener firebaseLoadListener;
    DatabaseReference topicsData;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz,container,false);

        FirebaseApp quizApp = FirebaseApp.getInstance("Topics");
        FirebaseDatabase topicsDatabase = FirebaseDatabase.getInstance(quizApp);

        topicsData = topicsDatabase.getReference("Topics");
        dialog = new SpotsDialog.Builder().setContext(getContext()).build();
        firebaseLoadListener = this;
        rvQuiz = rootView.findViewById(R.id.rv_quiz);
        rvQuiz.setLayoutManager(new LinearLayoutManager(getContext()));
        getTopicData();

        return rootView;
    }

    private void getTopicData() {
        dialog.show();
        topicsData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<TopicCards> topicCards = new ArrayList<>();
                for (DataSnapshot gs : dataSnapshot.getChildren()) {
                    TopicCards topicCard = new TopicCards();
                    topicCard.setTopic(gs.child("topic").getValue(true).toString());
                    GenericTypeIndicator<ArrayList<Topics>> l = new GenericTypeIndicator<ArrayList<Topics>>() {};
                    topicCard.setTopicCards(gs.child("quizCard").getValue(l));
                    topicCards.add(topicCard);
                }
                firebaseLoadListener.onFirebaseLoadSuccess(topicCards);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                firebaseLoadListener.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });
    }



    @Override
    public void onFirebaseLoadSuccess(List<TopicCards> topicCardsList) {
        VerticalAdapter adapter = new VerticalAdapter(getContext(), topicCardsList);
        rvQuiz.setAdapter(adapter);
        dialog.dismiss();
    }


    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}