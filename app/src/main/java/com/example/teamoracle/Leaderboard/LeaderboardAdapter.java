package com.example.teamoracle.Leaderboard;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.teamoracle.Quiz.User;
import com.example.teamoracle.R;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {

    private List<User> userList;
    private Context context;

    public LeaderboardAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.leaderboard_list_item, parent, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        User user = userList.get(i);
        holder.name.setText(user.getName());
        holder.total.setText(String.valueOf(user.getTotal()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, total;

        public ViewHolder(@NonNull View item) {
            super(item);
            name = item.findViewById(R.id.name);
            total = item.findViewById(R.id.total);
        }

    }
}
