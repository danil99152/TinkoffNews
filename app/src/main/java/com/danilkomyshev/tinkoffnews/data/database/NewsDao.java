package com.danilkomyshev.tinkoffnews.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.danilkomyshev.tinkoffnews.data.model.content.Content;
import com.danilkomyshev.tinkoffnews.data.model.content.Title;
import com.danilkomyshev.tinkoffnews.data.model.news.Note;

import java.util.List;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNews(List<Note> news);

    @Query("select * from note order by publicationDate desc")
    List<Note> getNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContent(Content content);

    @Query("select * from content")
    Content getContentById();


    @Query("select * from title")
    Title getTitleById();
}
