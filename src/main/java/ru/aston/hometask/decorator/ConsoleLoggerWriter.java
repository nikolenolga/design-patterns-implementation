package ru.aston.hometask.decorator;

public class ConsoleLoggerWriter implements LoggerWriter {
    private static final String MESSAGE_FORMAT = "%s: %s%n";

    @Override
    public void log(LoggerLevel level, String message) {
        System.out.printf(MESSAGE_FORMAT, level, message);
    }
}
