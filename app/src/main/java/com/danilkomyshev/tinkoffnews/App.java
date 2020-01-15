package com.danilkomyshev.tinkoffnews;

import android.app.Application;

import androidx.room.Room;

import com.danilkomyshev.tinkoffnews.data.database.NewsDatabase;
import com.danilkomyshev.tinkoffnews.data.database.Storage;

public class App extends Application {

    private Storage mStorage;

    @Override
    public void onCreate() {
        super.onCreate();

        final NewsDatabase database= Room.databaseBuilder(this, NewsDatabase.class, "news_database")
                .fallbackToDestructiveMigration()
                .build();

        mStorage = new Storage(database.getNewsDao());
    }

    public Storage getStorage() {
        return mStorage;
    }
}