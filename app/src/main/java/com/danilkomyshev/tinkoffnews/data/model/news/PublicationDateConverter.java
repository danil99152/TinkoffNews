package com.danilkomyshev.tinkoffnews.data.model.news;

import androidx.room.TypeConverter;

public class PublicationDateConverter {

    @TypeConverter
    public static PublicationDate fromTimestamp(Long value) {
        return value == null ? null : new PublicationDate(value);
    }

    @TypeConverter
    public static Long toTimestamp(PublicationDate date) {
        return date == null ? null : date.getMilliseconds();
    }

}