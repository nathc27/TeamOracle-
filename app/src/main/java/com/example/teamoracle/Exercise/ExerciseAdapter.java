package com.example.teamoracle.Exercise;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teamoracle.Forum.Post;
import com.example.teamoracle.Forum.PostDetailActivity;
import com.example.teamoracle.R;

import java.util.List;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private List<String> mItems;
    private Context mContext;

    public ExerciseAdapter(Context context, List<String> topics) {
        this.mContext = context;
        this.mItems = topics;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.exercise_page_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String t = mItems.get(position);

        //SET VIEW(SET TEXT)
        holder.tv_topic.setText(t);
        holder.bt_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ExerciseDetailActivity.class);
                intent.putExtra(Exercise.EXERCISE_TAG, t);
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
        public TextView tv_topic;
        public ImageView bt_enter;

        public ViewHolder(View itemView) {
            super(itemView);
            //TODO: you can change the layout by changing the layout id
            tv_topic = itemView.findViewById(R.id.tv_ec_topic);
            bt_enter = itemView.findViewById(R.id.btn_enter_exercise);
        }
    }
}
