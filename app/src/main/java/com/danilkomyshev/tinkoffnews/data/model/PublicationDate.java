package com.danilkomyshev.tinkoffnews.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PublicationDate implements Serializable {

    @SerializedName("milliseconds")
    private long milliseconds;

    long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }
}
