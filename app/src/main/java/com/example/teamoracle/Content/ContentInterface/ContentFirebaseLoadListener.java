package com.example.teamoracle.Content.ContentInterface;

import com.example.teamoracle.Content.ContentData.ContentCards;

import java.util.List;

public interface ContentFirebaseLoadListener {
    void onFirebaseLoadSuccess(List<ContentCards> contentCardsList);
    void onFirebaseLoadFailed(String message);
}
