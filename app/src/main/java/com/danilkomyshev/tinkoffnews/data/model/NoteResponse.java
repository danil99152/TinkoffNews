package com.danilkomyshev.tinkoffnews.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NoteResponse implements Serializable {

    @SerializedName("payload")
    private List<Note> mNews;

    public List<Note> getNews() {
        return mNews;
    }

    public void setNews(List<Note> news) {
        this.mNews = news;
    }
}
