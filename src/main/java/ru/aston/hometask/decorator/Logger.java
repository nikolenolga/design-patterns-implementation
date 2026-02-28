package ru.aston.hometask.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Logger {
    private final LoggerWriter loggerWriter;
    private final LoggerLevel loggerLevel;

    public void trace(String message) {
        checkLevelAndWrite(LoggerLevel.TRACE, message);
    }

    public void debug(String message) {
        checkLevelAndWrite(LoggerLevel.DEBUG, message);
    }

    public void info(String message) {
        checkLevelAndWrite(LoggerLevel.INFO, message);
    }

    public void warn(String message) {
        checkLevelAndWrite(LoggerLevel.WARN, message);
    }

    public void error(String message) {
        checkLevelAndWrite(LoggerLevel.ERROR, message);
    }

    public void fatal(String message) {
        checkLevelAndWrite(LoggerLevel.FATAL, message);
    }

    private void checkLevelAndWrite(LoggerLevel level, String message) {
        if (loggerLevel.isLevelHigher(level)) {
            return;
        }
        loggerWriter.log(level, message);
    }
}
