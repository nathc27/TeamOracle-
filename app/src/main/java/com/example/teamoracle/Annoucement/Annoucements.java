package com.example.teamoracle.Annoucement;


import java.util.ArrayList;

public class Annoucements {
    private String title;
    private String author;
    private String details;
    private String date;
    private String category;


    public Annoucements(){}

    public Annoucements(String title, String author, String details, String date, String category) {
        this.title = title;
        this.author = author;
        this.details = details;
        this.date = date;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static ArrayList<Annoucements> getDummyAnnoucements() {
        ArrayList<Annoucements> set = new ArrayList<>();

        set.add(new Annoucements("Welcome to INFS1609 Fundamentals of Busienss Programming","Yenni",".Hi all,\n" + "\n" + "Welcome to INFS1609 Mobile Application Development! We hope you have had an enjoyable summer and are ready for 2019.","02/08/2019","T1"));



        set.add(new Annoucements("Welcome to T2 2019","Yenni",".Hi all,\n" + "\n" + "Welcome to T2 2019! GET READY TO LEARN!!!","09/08/2019","T2"));


        set.add(new Annoucements("Assessment 1 Due","Yenni",".Hi all,\n" + "\n" + "A kind reminder that assessment 1 is due next week","20/08/2019","T1"));


        set.add(new Annoucements("Quiz Next Week","Yenni",".Hi all,\n" + "\n" + "A kind reminder that there is a quiz in your lectures next week","10/08/2019","T1"));

        return set;
    }
}
