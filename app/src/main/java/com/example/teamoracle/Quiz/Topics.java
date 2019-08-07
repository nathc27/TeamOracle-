package com.example.teamoracle.Quiz;

public class Topics {
    private String topic;
    private String  topicId;

    public Topics() {}

    public Topics(String topic, String topicId) {
        this.topic = topic;
        this.topicId = topicId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
}
