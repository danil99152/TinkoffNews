package com.danilkomyshev.tinkoffnews.data.model.content;

import com.google.gson.annotations.SerializedName;

public class PublicationDate {
    @SerializedName("milliseconds")
    private long milliseconds;

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }
}