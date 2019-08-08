package com.example.teamoracle.Forum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.teamoracle.R;

import java.util.List;

public class ForumDashboardActivity extends AppCompatActivity {
    private EditText text_title;
    private EditText text_post;
    private Button bt_post;
    private RecyclerView postRecycler;
    private List<Post> rootPosts;
    private DBHelper db;
    private ImageView btn_back;

    public static String author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: you can change the layout by changing the layout id
        setContentView(R.layout.forum_page);
        text_title = findViewById(R.id.text_title);
        text_post = findViewById(R.id.text_post);
        bt_post = findViewById(R.id.bt_post);
        btn_back = findViewById(R.id.btv_forum_back);

        author = this.getIntent().getStringExtra("Name");
        if (author == null) author = "Michael";

        //retrieve root posts from database
        db = new DBHelper(this);
        //db.cleanDatabase(); //TODO: uncomment this line and run it once to to clean the database on vm
        rootPosts = db.getRootPosts();
        //bind recycler layout
        postRecycler = findViewById(R.id.recyc_post);//TODO: you can change the layout by changing the layout id
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
                text_post.setText("");
                text_title.setText("");
                //refresh the list below
                rootPosts = db.getRootPosts();
                postRecycler.setAdapter(new PostAdapter(ForumDashboardActivity.this, rootPosts));
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public String getAuthor() {
        return author;
    }
}
