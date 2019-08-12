package com.example.teamoracle.Content;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.teamoracle.Content.ContentAdapter.ContentVerticalAdapter;
import com.example.teamoracle.Content.ContentData.ContentCardData;
import com.example.teamoracle.Content.ContentData.ContentCards;
import com.example.teamoracle.Content.ContentInterface.ContentFirebaseLoadListener;
import com.example.teamoracle.DashboardActivity;
import com.example.teamoracle.Quiz.Adapter.VerticalAdapter;
import com.example.teamoracle.Quiz.TopicCards;
import com.example.teamoracle.Quiz.Topics;
import com.example.teamoracle.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;


public class ContentFragment extends Fragment implements ContentFirebaseLoadListener {
    AlertDialog dialog;
    RecyclerView rvContent;
    ContentFirebaseLoadListener contentFirebaseLoadListener;
    DatabaseReference contentData;
    ImageView backButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content,container,false);

        FirebaseApp quizApp = FirebaseApp.getInstance("Topics");
        FirebaseDatabase contentDatabase = FirebaseDatabase.getInstance(quizApp);

        contentData = contentDatabase.getReference("Topics");
        dialog = new SpotsDialog.Builder().setContext(getContext()).build();
        contentFirebaseLoadListener = this;
        rvContent = rootView.findViewById(R.id.recyc_exercise);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        getContentData();

        return rootView;
    }

    private void getContentData() {
        dialog.show();
        contentData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ContentCards> contentsCards = new ArrayList<>();
                for (DataSnapshot gs : dataSnapshot.getChildren()) {
                    ContentCards contentCard = new ContentCards();
                    contentCard.setTopic(gs.child("topic").getValue(true).toString());
                    GenericTypeIndicator<ArrayList<ContentCardData>> c = new GenericTypeIndicator<ArrayList<ContentCardData>>() {};
                    contentCard.setContentCard(gs.child("contentCard").getValue(c));
                    contentsCards.add(contentCard);
                }
                contentFirebaseLoadListener.onFirebaseLoadSuccess(contentsCards);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                contentFirebaseLoadListener.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });
    }



    @Override
    public void onFirebaseLoadSuccess(List<ContentCards> contentCardsList) {
        ContentVerticalAdapter adapter = new ContentVerticalAdapter(getContext(), contentCardsList);
        rvContent.setAdapter(adapter);
        dialog.dismiss();
    }


    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}