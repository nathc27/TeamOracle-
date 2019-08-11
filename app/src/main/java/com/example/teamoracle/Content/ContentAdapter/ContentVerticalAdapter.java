package com.example.teamoracle.Content.ContentAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Content.ContentData.ContentCardData;
import com.example.teamoracle.Content.ContentData.ContentCards;
import com.example.teamoracle.Content.ContentInterface.ContentOnClickListener;
import com.example.teamoracle.Quiz.Adapter.HorizontalAdapter;
import com.example.teamoracle.Quiz.Adapter.VerticalAdapter;
import com.example.teamoracle.Quiz.Topics;
import com.example.teamoracle.R;

import java.util.List;

public class ContentVerticalAdapter extends RecyclerView.Adapter<ContentVerticalAdapter.ViewHolder> {

    private Context context;
    private List<ContentCards> dataList;
    private ContentOnClickListener contentOnClickListener;

    public ContentVerticalAdapter(Context context, List<ContentCards> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.content_vertical_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.contentTopic.setText(dataList.get(i).getTopic());
        List<ContentCardData> contentCardData = dataList.get(i).getContentCard();
        ContentHorizontalAdapter contentHorizontalAdapter = new ContentHorizontalAdapter(context, contentCardData, contentOnClickListener);
        holder.horizontalRVChild.setHasFixedSize(true);
        holder.horizontalRVChild.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.horizontalRVChild.setAdapter(contentHorizontalAdapter);
        holder.horizontalRVChild.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contentTopic;
        RecyclerView horizontalRVChild;

        public ViewHolder(@NonNull View view) {
            super(view);
            contentTopic = view.findViewById(R.id.content_topic);
            horizontalRVChild = view.findViewById(R.id.contentHorizontalRVChild);
        }
    }
}
