package com.danilkomyshev.tinkoffnews.data.model.content;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

@Entity
public class Content {

    @ColumnInfo(name = "content_id")
    @PrimaryKey
    @SerializedName("content_id")
    private int mId;

    @SerializedName("title")
    @Ignore
    private Title title;

    @ColumnInfo(name = "creationDate")
    @SerializedName("creationDate")
    @TypeConverters({CreationDateConverter.class})
    public CreationDate creationDate;

    @ColumnInfo(name = "lastModificationDate")
    @SerializedName("lastModificationDate")
    @TypeConverters({LastModificationDateConverter.class})
    public LastModificationDate lastModificationDate;

    @ColumnInfo(name = "content")
    @SerializedName("content")
    private String content;

    @SerializedName("bankInfoTypeId")
    private Integer bankInfoTypeId;

    @SerializedName("typeId")
    private String typeId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public Title getTitle() {
        return title;
    }

    public CreationDate getCreationDate() {
        return creationDate;
    }

    public LastModificationDate getLastModificationDate() {
        return lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Integer bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}