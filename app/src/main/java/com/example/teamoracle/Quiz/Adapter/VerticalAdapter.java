package com.example.teamoracle.Quiz.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Quiz.Interface.OnClickListener;
import com.example.teamoracle.Quiz.TopicCards;
import com.example.teamoracle.Quiz.Topics;
import com.example.teamoracle.R;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

    private Context context;
    private List<TopicCards> dataList;
    private OnClickListener onClickListener;

    public VerticalAdapter(Context context, List<TopicCards> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.vertical_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.topic.setText(dataList.get(i).getTopic());
        List<Topics> topics = dataList.get(i).getTopicCards();
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context, topics, onClickListener);
        holder.horizontalRVChild.setHasFixedSize(true);
        holder.horizontalRVChild.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.horizontalRVChild.setAdapter(horizontalAdapter);
        holder.horizontalRVChild.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return (dataList != null ? dataList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topic;
        RecyclerView horizontalRVChild;

        public ViewHolder(@NonNull View view) {
            super(view);
            topic = view.findViewById(R.id.topic);
            horizontalRVChild = view.findViewById(R.id.horizontalRVChild);
        }
    }
}
