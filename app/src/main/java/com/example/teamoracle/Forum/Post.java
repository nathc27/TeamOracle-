package com.example.teamoracle.Forum;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;

public class Post implements Parcelable {
    private int root;
    private int seq;
    private String author;
    private String postContent;
    private String title;

    public static final int ROOT_POST = -1;
    public static final String POST_TAG = "root_port";

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public Post(int root, int seq, String author, String postContent, String title) {
        this.root = root;
        this.seq = seq;
        this.author = author;
        this.postContent = postContent;
        this.title = title;
    }

    public Post(int root, String author, String postContent, String title) {
        this.root = root;
        this.author = author;
        this.postContent = postContent;
        this.title = title;
    }

    public Post() {
    }

    protected Post(Parcel in) {
        this.seq = in.readInt();
        this.root = in.readInt();
        this.author = in.readString();
        this.title = in.readString();
        this.postContent = in.readString();
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeq() {
        return seq;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(seq);
        parcel.writeString(author);
        parcel.writeInt(root);
        parcel.writeString(title);
        parcel.writeString(postContent);
    }
}