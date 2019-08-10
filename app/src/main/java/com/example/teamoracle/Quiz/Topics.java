package com.example.teamoracle.Quiz;

public class Topics {
    private String quizCardId;
    private String quizCardName;

    public Topics() {
    }

    public Topics(String quizCardId, String quizCardName) {
        this.quizCardId = quizCardId;
        this.quizCardName = quizCardName;
    }

    public String getQuizCardId() {
        return quizCardId;
    }

    public String getQuizCardName() {
        return quizCardName;
    }
}
