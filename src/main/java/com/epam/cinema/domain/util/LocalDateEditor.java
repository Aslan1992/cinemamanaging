package com.epam.cinema.domain.util;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        setValue(LocalDate.parse(text, formatter));
    }
}