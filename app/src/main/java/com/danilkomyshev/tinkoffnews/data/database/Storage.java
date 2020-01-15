package com.danilkomyshev.tinkoffnews.data.database;

import com.danilkomyshev.tinkoffnews.data.model.content.Content;
import com.danilkomyshev.tinkoffnews.data.model.content.ContentResponse;
import com.danilkomyshev.tinkoffnews.data.model.news.Note;
import com.danilkomyshev.tinkoffnews.data.model.news.NoteResponse;

import java.util.List;

public class Storage {
    private NewsDao mNewsDao;

    public Storage(NewsDao newsDao) {
        mNewsDao = newsDao;
    }

    public void insertNews(NoteResponse response) {
        List<Note> news = response.getNews();
        mNewsDao.insertNews(news);
    }

    public NoteResponse getNews() {
        List<Note> news = mNewsDao.getNews();

        NoteResponse response = new NoteResponse();
        response.setNews(news);
        return response;
    }

    public void insertContent(ContentResponse response) {
        Content content = response.getContent();
        mNewsDao.insertContent(content);
    }

    public ContentResponse getContent() {
        Content content = mNewsDao.getContentById();
        ContentResponse response = new ContentResponse();
        response.setContent(content);
        return response;
    }

    public interface StorageOwner {
        Storage obtainStorage();
    }
}