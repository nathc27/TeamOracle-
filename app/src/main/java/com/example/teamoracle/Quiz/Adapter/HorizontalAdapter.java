package com.example.teamoracle.Quiz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teamoracle.Quiz.Interface.OnClickListener;
import com.example.teamoracle.Quiz.StartQuizActivity;
import com.example.teamoracle.Quiz.Topics;
import com.example.teamoracle.R;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ViewHolder> {

    private Context context;
    private List<Topics> topics;
    private OnClickListener mOnClickListener;

    public HorizontalAdapter(Context context, List<Topics> topics, OnClickListener mOnClickListener) {
        this.context = context;
        this.topics = topics;
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.horizontal_list, parent, false);
        return new ViewHolder(itemView, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.learnCardName.setText(topics.get(position).getQuizCardName());
        holder.learnCardName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(topics.get(position).getQuizCardId().contains("L")) {
                    Intent intent = new Intent(context, StartQuizActivity.class);
                    intent.putExtra("quizCardId", topics.get(position).getQuizCardId());
                    intent.putExtra("quizCardName", topics.get(position).getQuizCardName());
                    intent.putExtra("card", topics.get(position).getQuizCardId());
                    context.startActivity(intent);

                }
                else{

                }
            }
            });
        }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView learnCardName;
        OnClickListener onClickListener;

        public ViewHolder(@NonNull View view, OnClickListener onClickListener) {
            super(view);
            learnCardName = view.findViewById(R.id.learnCardName);
            this.onClickListener = onClickListener;
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onClickListener.onClick(view, getAdapterPosition());
        }
    }
}