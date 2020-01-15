package com.danilkomyshev.tinkoffnews.data.model.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Note implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("text")
    private String text;
    @SerializedName("publicationDate")
    private PublicationDate publicationDate;
    @SerializedName("bankInfoTypeId")
    private Integer bankInfoTypeId;

    public Note(String text, PublicationDate publicationDate) {
        this.text = text;
        this.publicationDate = publicationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getPublicationDate() {
        return publicationDate.getMilliseconds();
    }

    public void setPublicationDate(PublicationDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }
}
