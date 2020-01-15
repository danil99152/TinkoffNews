package com.danilkomyshev.tinkoffnews.data.model.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PublicationDate implements Serializable {

    @SerializedName("milliseconds")
    private long milliseconds;
    PublicationDate(Long value) {
        milliseconds = value;
    }

    long getMilliseconds() {
        return milliseconds;
    }
}
