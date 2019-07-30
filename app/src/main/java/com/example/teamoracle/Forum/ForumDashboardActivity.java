package com.example.teamoracle.Forum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.teamoracle.R;

import java.util.List;

public class ForumDashboardActivity extends AppCompatActivity {
    private RecyclerView PostRecycler;
    private List<Post> rootPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);//TODO: change layout

        //TODO: get user

        //TODO: retrieve root posts from database

        //TODO: bind recycler layout
        PostRecycler.setLayoutManager(new LinearLayoutManager(this));
        PostRecycler.setAdapter(new PostAdapter(this, rootPosts));
    }
}
