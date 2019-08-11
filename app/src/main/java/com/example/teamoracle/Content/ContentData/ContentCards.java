package com.example.teamoracle.Content.ContentData;

import java.util.ArrayList;

public class ContentCards {
    private String topic;
    private ArrayList<ContentCardData> contentCard;

    public ContentCards() {
    }

    public ContentCards(String topic, ArrayList<ContentCardData> contentCard) {
        this.topic = topic;
        this.contentCard = contentCard;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<ContentCardData> getContentCard() {
        return contentCard;
    }

    public void setContentCard(ArrayList<ContentCardData> contentCard) {
        this.contentCard = contentCard;
    }
}
