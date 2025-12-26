package ru.aston.hometask.decorator;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class FileLoggerWriterDecorator extends BaseLoggerWriterDecorator {
    private final static Path ROOT_PATH = Paths.get(URI.create(
            Objects.requireNonNull(
                    FileLoggerWriterDecorator.class.getResource("/")
            ).toString()));
    private static final String MESSAGE_FORMAT = "%s: %s%n";
    private final Path logFilePath;


    public FileLoggerWriterDecorator(LoggerWriter wrapped, String logFilePath) {
        super(wrapped);
        this.logFilePath = ROOT_PATH.resolve(logFilePath);
    }

    @Override
    public void log(LoggerLevel level, String message) {
        super.log(level, message);
        writeLog(level, message);
    }

    private void writeLog(LoggerLevel level, String message) {
        try {
            Files.writeString(logFilePath, MESSAGE_FORMAT.formatted(level, message), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("%s: can't white log in file: %s, %s".formatted(FileLoggerWriterDecorator.class.getName(),
                    logFilePath, e.getMessage()));
        }
    }
}
