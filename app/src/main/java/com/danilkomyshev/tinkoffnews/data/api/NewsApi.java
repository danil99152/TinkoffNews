package com.danilkomyshev.tinkoffnews.data.api;

import com.danilkomyshev.tinkoffnews.data.model.content.ContentResponse;
import com.danilkomyshev.tinkoffnews.data.model.news.NoteResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v1/news")
    Single<NoteResponse> getNews();

    @GET("v1/news_content")
    Single<ContentResponse> getContent(@Query("id") int id);
}
