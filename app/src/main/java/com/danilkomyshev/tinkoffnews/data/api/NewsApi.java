package com.danilkomyshev.tinkoffnews.data.api;

import com.danilkomyshev.tinkoffnews.data.model.NoteResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("v1/news")
    Single<NoteResponse> getNews();
}
