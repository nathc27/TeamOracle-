package com.example.teamoracle.Forum;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Timestamp;

public class Post implements Parcelable {
    private int root;
    private int seq;
    private String displayName;
    private String postContent;
    private Timestamp timestamp;

}