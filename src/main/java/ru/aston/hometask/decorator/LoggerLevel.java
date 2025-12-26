package ru.aston.hometask.decorator;

public enum LoggerLevel {
    TRACE(0),
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5);

    private final Integer levelHeight;

    LoggerLevel(Integer levelHeight) {
        this.levelHeight = levelHeight;
    }

    public boolean isLevelHigher(LoggerLevel level) {
        return levelHeight > level.levelHeight;
    }
}
