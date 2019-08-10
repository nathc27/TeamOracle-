package com.example.teamoracle.Quiz;

import java.util.ArrayList;

public class TopicCards {
    private String topic;
    private ArrayList<Topics> topicCards;

    public TopicCards(){
    }

    public TopicCards(String topic, ArrayList<Topics> topicCards) {
        this.topic = topic;
        this.topicCards = topicCards;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<Topics> getTopicCards() {
        return topicCards;
    }

    public void setTopicCards(ArrayList<Topics> topicCards) {
        this.topicCards = topicCards;
    }
}
