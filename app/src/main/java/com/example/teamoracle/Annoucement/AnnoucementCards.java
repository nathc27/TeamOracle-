package com.example.teamoracle.Annoucement;

import java.util.ArrayList;

public class AnnoucementCards {
    private String title;
    private ArrayList<Annoucement> annoucementCard;

    public AnnoucementCards() {
    }

    public AnnoucementCards(String title, ArrayList<Annoucement> annoucementCard) {
        this.title = title;
        this.annoucementCard = annoucementCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Annoucement> getAnnoucementCard() {
        return annoucementCard;
    }

    public void setAnnoucementCard(ArrayList<Annoucement> annoucementCard) {
        this.annoucementCard = annoucementCard;
    }
}
