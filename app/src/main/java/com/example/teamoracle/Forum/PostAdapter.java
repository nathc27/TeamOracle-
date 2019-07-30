package com.example.teamoracle.Forum;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.R;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> mItems;
    private Context mContext;

    public PostAdapter(Context context, List<Post> posts) {
        this.mContext = context;
        this.mItems = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.forum_page_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post post = mItems.get(position);

        //SET VIEW(SET TEXT)
        holder.tv_title.setText(post.getTitle());
        holder.tv_author.setText(post.getAuthor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PostDetailActivity.class);
                intent.putExtra(Post.POST_TAG, post);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //DECLARE VIEW
        public TextView tv_title;
        public TextView tv_author;

        public ViewHolder(View itemView) {
            super(itemView);
            //BIND VIEW
            tv_title = itemView.findViewById(R.id.tv_forum_topic);
            tv_author = itemView.findViewById(R.id.tv_forum_author);
        }
    }
}
