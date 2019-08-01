package com.example.teamoracle.Forum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.R;

import java.util.List;

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ViewHolder> {

    private List<Post> mItems;
    private Context mContext;

    public ResponseAdapter(Context context, List<Post> posts) {
        this.mContext = context;
        this.mItems = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.forum_page_reply_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post post = mItems.get(position);

        //SET VIEW(SET TEXT)
        holder.tv_content.setText(post.getPostContent());
        holder.tv_author.setText(post.getAuthor());
    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //DECLARE VIEW
        public TextView tv_content;
        public TextView tv_author;

        public ViewHolder(View itemView) {
            super(itemView);
            //TODO: you can change the layout by changing the layout id
            tv_content = itemView.findViewById(R.id.tv_discussion_reply);
            tv_author = itemView.findViewById(R.id.reply_author);
        }
    }
}
