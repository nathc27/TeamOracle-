package com.example.teamoracle.Annoucement;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Forum.Post;
import com.example.teamoracle.Forum.PostAdapter;
import com.example.teamoracle.Forum.PostDetailActivity;
import com.example.teamoracle.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AnnoucementAdapter extends RecyclerView.Adapter<AnnoucementAdapter.ViewHolder> {

    public TextView tv_title;
    public TextView tv_author;
    public TextView tv_details;
    private Context context;
    private List<Annoucements> annoucementList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AnnoucementAdapter(Context context, ArrayList<Annoucements> annoucementList) {
        context = context;
        annoucementList = annoucementList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.announcement_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Annoucements currentItem = annoucementList.get(position);

        String author = currentItem.getAuthor();
        String title = currentItem.getTitle();
        String details = currentItem.getDetails();
        String  date = currentItem.getDate();

        holder.tv_author.setText(author);
        holder.tv_title.setText(title);
        holder.tv_details.setText(details);
    }

    @Override
    public int getItemCount() {
        return annoucementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_author;
        public TextView tv_title;
        public TextView tv_details;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_author = itemView.findViewById(R.id.tv_announcement_author);
            tv_title = itemView.findViewById(R.id.tv_announcement);
            tv_details = itemView.findViewById(R.id.tv_announcement_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

