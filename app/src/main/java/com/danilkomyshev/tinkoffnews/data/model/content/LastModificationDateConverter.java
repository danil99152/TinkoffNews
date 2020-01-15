package com.danilkomyshev.tinkoffnews.data.model.content;

import androidx.room.TypeConverter;

public class LastModificationDateConverter {

    @TypeConverter
    public static LastModificationDate fromTimestamp(Long value) {
        return value == null ? null : new LastModificationDate(value);
    }

    @TypeConverter
    public static Long toTimestamp(LastModificationDate date) {
        return date == null ? null : date.getMilliseconds();
    }
}