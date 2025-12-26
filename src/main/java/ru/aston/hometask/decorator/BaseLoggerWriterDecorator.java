package ru.aston.hometask.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseLoggerWriterDecorator implements LoggerWriter {
    private final LoggerWriter wrapped;

    @Override
    public void log(LoggerLevel level, String message) {
        wrapped.log(level, message);
    }
}
