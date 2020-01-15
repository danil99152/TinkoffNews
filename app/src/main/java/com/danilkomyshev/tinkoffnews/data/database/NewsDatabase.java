package com.danilkomyshev.tinkoffnews.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.danilkomyshev.tinkoffnews.data.model.content.Content;
import com.danilkomyshev.tinkoffnews.data.model.content.Title;
import com.danilkomyshev.tinkoffnews.data.model.news.Note;

@Database(entities = {Note.class, Content.class, Title.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsDao getNewsDao();
}