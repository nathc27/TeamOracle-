package com.example.teamoracle.Forum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.teamoracle.R;

import org.w3c.dom.Text;

import java.util.List;

public class PostDetailActivity extends AppCompatActivity {
    private RecyclerView responseRecycler;
    private List<Post> responses;
    private TextView tv_rootPost;
    private TextView tv_Author;
    private EditText text_response;
    private Button bt_Reply;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final Post root = this.getIntent().getParcelableExtra(Post.POST_TAG);
        //bind view
        tv_rootPost = findViewById(R.id.tv_root_post);
        tv_Author = findViewById(R.id.tv_author);
        text_response = findViewById(R.id.text_response);
        bt_Reply = findViewById(R.id.bt_reply);

        //TODO: show post detail -> need to test output
        String rootPostText = "\"" + root.getTitle() + "\"\n\n" + root.getPostContent();
        tv_rootPost.setText(rootPostText);

        //TODO: get responses from database
        db = new DBHelper(this);
        responses = DBHelper.getResponses(root.getSeq());

        responseRecycler = findViewById(R.id.recyc_responses);
        responseRecycler.setLayoutManager(new LinearLayoutManager(this));
        responseRecycler.setAdapter(new ResponseAdapter(this, responses));


        //create response
        bt_Reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post newResponse = new Post();
                newResponse.setRoot(root.getSeq());
                newResponse.setTitle(root.getTitle());
                newResponse.setPostContent(text_response.getText().toString());
                newResponse.setAuthor(ForumDashboardActivity.author);

                DBHelper.createPost(newResponse);

                //refresh the response list
                responses = DBHelper.getResponses(root.getSeq());
                responseRecycler.setAdapter(new ResponseAdapter(PostDetailActivity.this, responses));
            }
        });
    }
}
