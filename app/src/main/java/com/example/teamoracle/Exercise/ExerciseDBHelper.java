package com.example.teamoracle.Exercise;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.teamoracle.Forum.Post;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ExerciseDBHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "ExDatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "teamoracle.exercise_database.post";


    public ExerciseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        Cursor c = db.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = 'exercise'", null);
        if (c.getCount() <= 0) {
            db.execSQL("CREATE TABLE IF NOT EXISTS exercise ("
                    + "seq INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "topic TEXT,"
                    + "question TEXT,"
                    + "answer TEXT)");

            //TODO: insert exercise data
        }
        Log.i("Exercise DB SETTING", "TABLE CREATION COMPLETED");
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
    public void createExercise(Exercise e) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("topic", e.getTopic());
        c.put("question", e.getQuestion());
        c.put("answer", e.getAnswer());
        db.insert("exercise", null, c);
        Log.i("DATABASE", "EXERCISE CREATED", null);
        db.close();
    }

    public List<String> getTopics() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> topics = new ArrayList<String>();
        Cursor c = db.rawQuery("SELECT DISTINCT topic FROM exercose", null);
        while (c.moveToNext()) {
            topics.add(c.getString(c.getColumnIndex("topic")));
        }
        db.close();
        return topics;
    }

    public Queue<Exercise> getExerciseByTopic(String t) {
        SQLiteDatabase db = this.getReadableDatabase();
        Queue<Exercise> exercises = new LinkedList<>();
        Cursor c = db.rawQuery("SELECT * FROM exercose WHERE topic = " + t, null);
        while (c.moveToNext()) {
            Exercise e = new Exercise();
            e.setSeq(c.getInt(c.getColumnIndex("seq")));
            e.setTopic(c.getString(c.getColumnIndex("topic")));
            e.setQuestion(c.getString(c.getColumnIndex("question")));
            e.setAnswer(c.getString(c.getColumnIndex("answer")));
            exercises.add(e);
        }
        db.close();
        return exercises;
    }
}
