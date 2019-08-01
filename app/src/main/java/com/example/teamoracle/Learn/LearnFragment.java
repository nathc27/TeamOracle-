package com.example.teamoracle.Learn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.WidgetContainer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teamoracle.Content.ContentActivity;
import com.example.teamoracle.DashboardActivity;
import com.example.teamoracle.Exercise.ExerciseActivity;
import com.example.teamoracle.Forum.ForumActivity;
import com.example.teamoracle.Forum.ForumDashboardActivity;
import com.example.teamoracle.Leaderboard.LeaderboardActivity;
import com.example.teamoracle.Quiz.QuizActivity;
import com.example.teamoracle.R;


public class LearnFragment extends Fragment {
    private CardView contentWidget, quizWidget, exerciseWidget, forumWidget, leaderboardWidget;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_learn, container, false);
        contentWidget = rootView.findViewById(R.id.content_widget);
        quizWidget = rootView.findViewById(R.id.quiz_widget);
        exerciseWidget = rootView.findViewById(R.id.exercise_widget);
        forumWidget = rootView.findViewById(R.id.forum_widget);
        leaderboardWidget = rootView.findViewById(R.id.leaderboard_widget);
        contentWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContent();
            }
        });
        quizWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });
        exerciseWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExercise();
            }
        });
        forumWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForum();
            }
        });
        leaderboardWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLeaderboard();
            }
        });
        return rootView;

    }

    void openContent() {
        Intent signUp = new Intent(this.getContext(), ContentActivity.class);
        startActivity(signUp);
    }

    void openQuiz() {
        Intent signUp = new Intent(this.getContext(), QuizActivity.class);
        startActivity(signUp);
    }

    void openExercise() {
        Intent signUp = new Intent(this.getContext(), ExerciseActivity.class);
        startActivity(signUp);
    }

    void openForum() {
        Intent forum = new Intent(this.getContext(), ForumDashboardActivity.class);
        forum.putExtra("Name", this.getActivity().getIntent().getStringExtra("Name"));
        startActivity(forum);
    }

    void openLeaderboard() {
        Intent signUp = new Intent(this.getContext(), LeaderboardActivity.class);
        startActivity(signUp);
    }
}
