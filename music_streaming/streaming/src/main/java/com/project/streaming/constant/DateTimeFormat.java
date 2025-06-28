package com.project.streaming.constant;


import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@AllArgsConstructor
public enum DateTimeFormat {

    ddMMyyyy("ddMMyyyy", "dd/MM/yyyy HH:mm:ss.SSS");

    private final String key;
    private final String pattern;

    public DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
