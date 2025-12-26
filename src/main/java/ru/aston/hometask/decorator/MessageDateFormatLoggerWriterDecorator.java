package ru.aston.hometask.decorator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageDateFormatLoggerWriterDecorator extends BaseLoggerWriterDecorator {
    private static final String MESSAGE_FORMAT = "%s: %s";
    private final DateTimeFormatter dateTimeFormatter;

    public MessageDateFormatLoggerWriterDecorator(LoggerWriter wrapped, DateTimeFormatter dateTimeFormatter) {
        super(wrapped);
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public void log(LoggerLevel level, String message) {
        super.log(level, formatLogMessage(message));
    }

    private String formatLogMessage(String message) {
        return MESSAGE_FORMAT.formatted(LocalDateTime.now().format(dateTimeFormatter), message);
    }
}
