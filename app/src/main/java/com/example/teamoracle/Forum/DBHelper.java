package com.example.teamoracle.Forum;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "teamoracle.database.post";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL("CREATE TABLE IF NOT EXISTS post ("
                + "seq INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "root INTEGER,"
                + "title TEXT,"
                + "content TEXT,"
                + "author TEXT)");
        Log.i("DATABASE SETTING", "TABLE CREATION COMPLETED");
    }

    //onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS post");
        // create new tables
        onCreate(db);
    }

    public void cleanDatabase() {
        // on upgrade drop older tables
        Log.i("CLEAN", "cleaning database");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS post");
        onCreate(db);
        Log.i("CLEAN", "DATABASE CLEANED");
    }

    //create post
    public void createPost(Post post) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("root", post.getRoot());
        c.put("title", post.getTitle());
        c.put("content", post.getPostContent());
        c.put("author", post.getAuthor());
        db.insert("post", null, c);
        Log.i("DATABASE", "POST CREATED");
        db.close();
    }

    //get root post
    public List<Post> getRootPosts() {
        List<Post> rootPosts = new ArrayList<Post>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM post WHERE root =" + Post.ROOT_POST + " ORDER BY seq DESC", null);
        while (c.moveToNext()) {
            Post p = new Post();
            p.setSeq(c.getInt(c.getColumnIndex("seq")));
            p.setRoot(c.getInt(c.getColumnIndex("root")));
            p.setTitle(c.getString(c.getColumnIndex("title")));
            p.setPostContent(c.getString(c.getColumnIndex("content")));
            p.setAuthor(c.getString(c.getColumnIndex("author")));
            rootPosts.add(p);
        }
        db.close();
        return rootPosts;
    }

    //get responses for one post
    public List<Post> getResponses(int root) {
        List<Post> responses = new ArrayList<Post>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM post WHERE root =" + root + " ORDER BY seq", null);
        while (c.moveToNext()) {
            Post p = new Post();
            p.setSeq(c.getInt(c.getColumnIndex("seq")));
            p.setRoot(c.getInt(c.getColumnIndex("root")));
            p.setTitle(c.getString(c.getColumnIndex("title")));
            p.setPostContent(c.getString(c.getColumnIndex("content")));
            p.setAuthor(c.getString(c.getColumnIndex("author")));
            responses.add(p);
        }
        return responses;
    }
}
