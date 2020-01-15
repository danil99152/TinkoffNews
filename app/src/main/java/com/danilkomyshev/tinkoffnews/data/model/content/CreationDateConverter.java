package com.danilkomyshev.tinkoffnews.data.model.content;

import androidx.room.TypeConverter;

public class CreationDateConverter {

    @TypeConverter
    public static CreationDate fromTimestamp(Long value) {
        return value == null ? null : new CreationDate(value);
    }

    @TypeConverter
    public static Long toTimestamp(CreationDate date) {
        return date == null ? null : date.getMilliseconds();
    }
}