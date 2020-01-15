package com.danilkomyshev.tinkoffnews.data.model.content;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ContentResponse implements Serializable {


    @SerializedName("payload")
    private Content mContent;

    public Content getContent() {
        return mContent;
    }

    public void setContent(Content content) {
        mContent = content;
    }
}