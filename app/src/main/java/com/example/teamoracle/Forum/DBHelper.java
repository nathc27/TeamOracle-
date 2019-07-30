package com.example.teamoracle.Forum;


import android.content.Context;
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

    // Table Creation Statement
    private static final String CREATE_TABLE_POST = "CREATE TABLE IF NOT EXISTS "
            + DatabaseContract.QuestionEntry.TABLE_QUESTION
            + "(" + DatabaseContract.QuestionEntry.KEY_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DatabaseContract.QuestionEntry.QUESTION_CONTENT + " TEXT,"
            + DatabaseContract.QuestionEntry.QUESTION_CATEGORY + " INTEGER,"
            + DatabaseContract.QuestionEntry.QUESTION_DIFFICULTY + " INTEGER,"
            + DatabaseContract.QuestionEntry.QUESTION_ANSWER_OPTIONS_1 + " TEXT,"
            + DatabaseContract.QuestionEntry.QUESTION_ANSWER_OPTIONS_2 + " TEXT,"
            + DatabaseContract.QuestionEntry.QUESTION_ANSWER_OPTIONS_3 + " TEXT,"
            + DatabaseContract.QuestionEntry.QUESTION_ANSWER_OPTIONS_4 + " TEXT,"
            + DatabaseContract.QuestionEntry.QUESTION_TRUE_ANSWER + " INTEGER" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_QUESTION);
        db.execSQL(CREATE_TABLE_RECORD);
        Log.i("DATABASE SETTING", "TABLE CREATION COMPLETED");
    }

    //onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.QuestionEntry.TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.RecordEntry.TABLE_RECORD);
        // create new tables
        onCreate(db);
    }

    public void cleanDatabase() {
        // on upgrade drop older tables
        Log.d("CLEAN", "cleaning database");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.QuestionEntry.TABLE_QUESTION);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.RecordEntry.TABLE_RECORD);
        onCreate(db);
        Log.d("CLEAN", "DATABASE CLEANED");
    }

    //TODO: create post query
    public static void createPost(Post post) {

    }

    //TODO: get root post
    public static List<Post> getRootPosts() {
        List<Post> rootPosts = new ArrayList<Post>();
        return rootPosts;
    }

    //TODO: get responses for one post
    public static List<Post> getResponses(int root) {
        List<Post> rootPosts = new ArrayList<Post>();
        return rootPosts;
    }
}
