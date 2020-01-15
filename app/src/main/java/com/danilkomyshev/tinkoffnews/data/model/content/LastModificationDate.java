package com.danilkomyshev.tinkoffnews.data.model.content;

import com.google.gson.annotations.SerializedName;

public class LastModificationDate {
    @SerializedName("milliseconds")
    private long milliseconds;

    LastModificationDate(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }
}