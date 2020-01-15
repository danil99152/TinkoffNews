package com.danilkomyshev.tinkoffnews.data.model.content;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreationDate implements Serializable {

    @SerializedName("milliseconds")
    private long milliseconds;

    CreationDate(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Integer milliseconds) {
        this.milliseconds = milliseconds;
    }
}