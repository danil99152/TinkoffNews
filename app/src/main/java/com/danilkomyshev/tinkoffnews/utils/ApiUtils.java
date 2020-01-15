package com.danilkomyshev.tinkoffnews.utils;

import com.danilkomyshev.tinkoffnews.data.api.NewsApi;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {

    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static NewsApi sApi;

    private static Retrofit getRetrofit() {
        if (sGson == null) {
            sGson = new Gson();
        }

        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl("https://api.tinkoff.ru/")
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static NewsApi getNewsApi() {
        if (sApi == null) {
            sApi = getRetrofit().create(NewsApi.class);
        }

        return sApi;
    }

}