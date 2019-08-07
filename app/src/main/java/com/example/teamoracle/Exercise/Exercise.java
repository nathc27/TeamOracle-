package com.example.teamoracle.Exercise;

public class Exercise {
    private int seq;
    private String topic;
    private String question;
    private String answer;

    public final static String EXERCISE_TAG = "exercise";

    public Exercise() {
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
