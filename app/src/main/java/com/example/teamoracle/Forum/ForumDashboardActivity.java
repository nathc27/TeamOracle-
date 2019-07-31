package com.example.teamoracle.Forum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teamoracle.R;

import java.util.List;

public class ForumDashboardActivity extends AppCompatActivity {
    private EditText text_title;
    private EditText text_post;
    private Button bt_post;
    private RecyclerView postRecycler;
    private List<Post> rootPosts;
    private DBHelper db;

    public static String author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forum_page);
        text_title = findViewById(R.id.text_title);
        text_post = findViewById(R.id.text_post);
        bt_post = findViewById(R.id.bt_post);

        //TODO: you can remove try-catch block after passing the user name in from dashboard activity
        author = this.getIntent().getStringExtra("Name");
        if (author.isEmpty()) author = "Michael";

        //retrieve root posts from database
        db = new DBHelper(this);
        db.cleanDatabase();
        rootPosts = db.getRootPosts();
        //bind recycler layout
        postRecycler = findViewById(R.id.recyc_post);
        postRecycler.setLayoutManager(new LinearLayoutManager(this));
        postRecycler.setAdapter(new PostAdapter(this, rootPosts));

        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create post
                Post newPost = new Post();
                newPost.setAuthor(author);
                newPost.setTitle(text_title.getText().toString());
                newPost.setPostContent(text_post.getText().toString());
                newPost.setRoot(Post.ROOT_POST);
                db.createPost(newPost);

                //refresh the list below
                rootPosts = db.getRootPosts();
                postRecycler.setAdapter(new PostAdapter(ForumDashboardActivity.this, rootPosts));
            }
        });
    }

    public String getAuthor() {
        return author;
    }
}
