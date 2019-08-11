package com.example.teamoracle.Content.ContentData;

public class ContentCardData {
    private String contentCardId, contentCardName, youtubeId, contentInformation;

    public ContentCardData() {
    }

    public ContentCardData(String contentCardId, String contentCardName, String youtubeId, String contentInformation) {
        this.contentCardId = contentCardId;
        this.contentCardName = contentCardName;
        this.youtubeId = youtubeId;
        this.contentInformation = contentInformation;
    }

    public String getContentCardId() {
        return contentCardId;
    }

    public String getContentCardName() {
        return contentCardName;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public String getContentInformation() {
        return contentInformation;
    }
}
