package com.example.teamoracle.Quiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Quiz.Topics;
import com.example.teamoracle.R;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    private List<Topics> topicsList;
    private Context context;

    public QuizAdapter(List<Topics> topicsList, Context context) {
        this.topicsList = topicsList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.quiz_menu_list_item, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Topics topics = topicsList.get(i);
        holder.topic.setText(topics.getTopic());
    }

    @Override
    public int getItemCount() {
        return topicsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView topic;

        public ViewHolder(@NonNull View item) {
            super(item);
            topic = item.findViewById(R.id.quiz_title);
        }

    }

}
