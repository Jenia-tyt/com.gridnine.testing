package com.gridnine.testing.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterTime {
    private FormatterTime() {
    }

    public static String formatterTime(LocalDateTime dateTime){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return dateTime.format(fmt);
    }
}
