package com.example.teamoracle.Content.ContentAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Content.ContentData.ContentCardData;
import com.example.teamoracle.Content.ContentInterface.ContentOnClickListener;
import com.example.teamoracle.Content.LessonActivity;
import com.example.teamoracle.R;

import java.util.List;

public class ContentHorizontalAdapter extends RecyclerView.Adapter<ContentHorizontalAdapter.ViewHolder>  {
    private Context context;
    private List<ContentCardData> contentCardDataList;
    private ContentOnClickListener mContentOnClickListener;

    public ContentHorizontalAdapter(Context context, List<ContentCardData> contentCardDataList, ContentOnClickListener mContentOnClickListener) {
        this.context = context;
        this.contentCardDataList = contentCardDataList;
        this.mContentOnClickListener = mContentOnClickListener;
    }

    @Override
    public ContentHorizontalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.content_horizontal_list, parent, false);
        return new ContentHorizontalAdapter.ViewHolder(itemView, mContentOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHorizontalAdapter.ViewHolder holder, final int position) {
        holder.contentCardName.setText(contentCardDataList.get(position).getContentCardName());
        holder.contentCardName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(contentCardDataList.get(position).getContentCardId().contains("C")) {
                    Intent intent = new Intent(context, LessonActivity.class);
                    intent.putExtra("contentCardId", contentCardDataList.get(position).getContentCardId());
                    intent.putExtra("youtubeId", contentCardDataList.get(position).getYoutubeId());
                    intent.putExtra("contentInformation", contentCardDataList.get(position).getContentInformation());
                    intent.putExtra("card", contentCardDataList.get(position).getContentCardId());
                    context.startActivity(intent);

                }
                else{

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return contentCardDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView contentCardName;
        ContentOnClickListener contentOnClickListener;

        public ViewHolder(@NonNull View view, ContentOnClickListener contentOnClickListener) {
            super(view);
            contentCardName = view.findViewById(R.id.contentCardName);
            this.contentOnClickListener = contentOnClickListener;
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            contentOnClickListener.onClick(view, getAdapterPosition());
        }
    }
}