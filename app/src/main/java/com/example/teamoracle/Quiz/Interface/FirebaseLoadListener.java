package com.example.teamoracle.Quiz.Interface;

import com.example.teamoracle.Quiz.TopicCards;


import java.util.List;

public interface FirebaseLoadListener {
    void onFirebaseLoadSuccess(List<TopicCards> topicsList);
    void onFirebaseLoadFailed(String message);
}
