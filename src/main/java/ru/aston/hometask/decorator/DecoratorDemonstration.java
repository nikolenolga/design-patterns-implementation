package ru.aston.hometask.decorator;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class DecoratorDemonstration {
    public static void demonstrateDecorator() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ConsoleLoggerWriter consoleLoggerWriter = new ConsoleLoggerWriter();
        FileLoggerWriterDecorator fileLoggerWriter = new FileLoggerWriterDecorator(consoleLoggerWriter, "log.txt");
        MessageDateFormatLoggerWriterDecorator loggerWriter = new MessageDateFormatLoggerWriterDecorator(fileLoggerWriter, dateTimeFormatter);
        Logger logger = new Logger(loggerWriter, LoggerLevel.WARN);

        logger.info("Some logged message");
        logger.error("Some logged message");
    }
}
