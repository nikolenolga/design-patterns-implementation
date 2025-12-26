package ru.aston.hometask;

import ru.aston.hometask.adapter.User;
import ru.aston.hometask.adapter.UserService;
import ru.aston.hometask.adapter.UserStorage;
import ru.aston.hometask.adapter.UserStorageRepositoryAdapter;
import ru.aston.hometask.builder.Message;
import ru.aston.hometask.builder.MessageType;
import ru.aston.hometask.chainOfResponsibility.ChainOfResponsibilityDemonstration;
import ru.aston.hometask.decorator.*;
import ru.aston.hometask.proxy.Audio;
import ru.aston.hometask.proxy.AudioCacheProxy;
import ru.aston.hometask.proxy.AudioService;
import ru.aston.hometask.proxy.RemoteAudioStorage;
import ru.aston.hometask.strategy.Document;
import ru.aston.hometask.strategy.Printer;
import ru.aston.hometask.strategy.StrategyKey;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Demonstration {
    public static void main(String[] args) {
        demonstrateAdapter();
        demonstrateBuilder();
        demonstrateChainOfResponsibility();
        demonstrateDecorator();
        demonstrateProxy();
        demonstrateStrategy();
    }

    public static void demonstrateAdapter() {
        System.out.println("ADAPTER PATTERN: create and use user service with adapter");
        UserStorage userStorage = new UserStorage();
        userStorage.save(new User(null, "olga", "12345"));
        userStorage.save(new User(null, "sergey", "qwerty"));

        UserService userService = new UserService(new UserStorageRepositoryAdapter(userStorage));
        userService.findById(1L).ifPresent(System.out::println);
        userService.findById(2L).ifPresent(System.out::println);
    }

    public static void demonstrateBuilder() {
        System.out.println("BUILDER PATTERN: build message");
        Message message = Message.builder().id(4L)
                .type(MessageType.TEXT)
                .addMessageText("Hello. ").addMessageText("My name is ")
                .addMessageText("Olga.")
                .messageDateTime(LocalDateTime.MIN)
                .messageSenderName("Olga")
                .messageReceiverName("Sergey")
                .priority(3)
                .language(Locale.ENGLISH)
                .build();
        System.out.println(message);
    }

    public static void demonstrateChainOfResponsibility() {
        System.out.println("CHAIN OF RESPONSIBILITY PATTERN: create filter chain and filter stream of 100 random tasks");
        ChainOfResponsibilityDemonstration.demonstrateChainOfResponsibility();
    }

    public static void demonstrateDecorator() {
        System.out.println("DECORATOR PATTERN: create and use console logger writer with file and message date format decorators");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        ConsoleLoggerWriter consoleLoggerWriter = new ConsoleLoggerWriter();
        FileLoggerWriterDecorator fileLoggerWriter = new FileLoggerWriterDecorator(consoleLoggerWriter, "log.txt");
        MessageDateFormatLoggerWriterDecorator loggerWriter = new MessageDateFormatLoggerWriterDecorator(fileLoggerWriter, dateTimeFormatter);
        Logger logger = new Logger(loggerWriter, LoggerLevel.WARN);

        logger.info("Info logged message");
        logger.error("Error logged message");
    }

    public static void demonstrateProxy() {
        System.out.println("PROXY PATTERN: save audio, get cached audio");
        AudioService audioService = new AudioService(new AudioCacheProxy(new RemoteAudioStorage()));
        Audio saveAudio = audioService.saveAudio(new Audio(0L, "song.mp3", new byte[0]));
        audioService.downloadAudio(saveAudio.getId());
    }

    public static void demonstrateStrategy() {
        System.out.println("STRATEGY PATTERN: printer using standard print strategy and choose strategy by key");
        Printer printer = new Printer();
        Document document = new Document(1L, "example.txt", "Document text.");
        printer.print(document);
        printer.print(StrategyKey.COLOR, document);
    }
}
