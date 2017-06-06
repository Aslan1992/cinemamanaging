package com.epam.cinema.domain.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
        setValue(LocalTime.parse(text, formatter));
    }
}
