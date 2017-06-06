package com.epam.cinema.domain.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

@Converter
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime entityValue) {
        if (entityValue == null) {
            return null;
        }
        return Time.valueOf(entityValue);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        return databaseValue.toLocalTime();
    }
}
