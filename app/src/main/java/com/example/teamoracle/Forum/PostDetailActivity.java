package com.example.teamoracle.Forum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.teamoracle.R;

import java.util.List;

public class PostDetailActivity extends AppCompatActivity {
    private RecyclerView responseRecycler;
    private List<Post> responses;
    private Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //TODO: bind view

        //TODO: show post detail

        //TODO: get responses from database
        responseRecycler.setLayoutManager(new LinearLayoutManager(this));
        responseRecycler.setAdapter(new ResponseAdapter(this, responses));

        //TODO: create post
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
