package com.example.teamoracle.Annoucement;

import java.util.Date;

public class Annoucement {
    public String annoucementId, author, annoucementContent, title;
    public Date postDate;

    public Annoucement() {
    }

    public Annoucement(String annoucementId, String author, String annoucementContent, String title, Date postDate ) {
        this.annoucementId = annoucementId;
        this.author = author;
        this.annoucementContent = annoucementContent;
        this.title = title;
        this.postDate= postDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnnoucementContent() {
        return annoucementContent;
    }

    public void setAnnoucementContent(String annoucementContent) {
        this.annoucementContent = annoucementContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getAnnoucementId() {
        return annoucementId;
    }

    public void setAnnoucementId(String annoucementId) {
        this.annoucementId = annoucementId;
    }
}
