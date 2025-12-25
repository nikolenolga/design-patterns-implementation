package ru.aston.hometask;

import ru.aston.hometask.adapter.User;
import ru.aston.hometask.adapter.UserService;
import ru.aston.hometask.adapter.UserStorage;
import ru.aston.hometask.adapter.UserStorageRepositoryAdapter;
import ru.aston.hometask.builder.Message;
import ru.aston.hometask.chainOfResponsibility.ChainOfResponsibilityDemonstration;
import ru.aston.hometask.proxy.DocumentCacheProxy;
import ru.aston.hometask.proxy.DocumentService;
import ru.aston.hometask.proxy.RemoteDocumentStorage;
import ru.aston.hometask.strategy.Document;
import ru.aston.hometask.strategy.Printer;
import ru.aston.hometask.strategy.StrategyKey;

import java.time.LocalDateTime;

public class Demonstration {
    public static void main(String[] args) {
        demonstrateStrategy();
        demonstrateBuilder();
        demonstrateChainOfResponsibility();
        demonstrateProxy();
        demonstrateAdapter();
    }

    public static void demonstrateStrategy() {
        System.out.println("STRATEGY PATTERN: printer using standard print strategy and choose strategy by key");
        Printer printer = new Printer();
        Document document = new Document(1L, "example.txt", "Document text.");
        printer.print(document);
        printer.print(StrategyKey.COLOR, document);
        System.out.println("------------------------------");
    }

    public static void demonstrateBuilder() {
        System.out.println("BUILDER PATTERN: build message");
        Message message = Message.builder().id(4L)
                .messageDateTime(LocalDateTime.MIN)
                .addMessageText("Hello. ").addMessageText("My name is ")
                .addMessageText("Olga.").build();
        System.out.println(message);
        System.out.println("------------------------------");
    }

    public static void demonstrateChainOfResponsibility() {
        System.out.println("CHAIN OF RESPONSIBILITY PATTERN: create filter chain and filter stream of 100 random tasks");
        ChainOfResponsibilityDemonstration.demonstrateChainOfResponsibility();
        System.out.println("------------------------------");
    }

    public static void demonstrateProxy() {
        System.out.println("PROXY PATTERN: save document, get cached document");
        DocumentService documentService = new DocumentService(new DocumentCacheProxy(new RemoteDocumentStorage()));

        Document saveDocument = documentService.saveDocument(new Document(0L, "text.txt", "Document text example"));
        documentService.downloadDocument(saveDocument.getId());
        System.out.println("------------------------------");
    }

    public static void demonstrateAdapter() {
        System.out.println("Adapter PATTERN: create and use user service with adapter");
        UserStorage userStorage = new UserStorage();
        userStorage.save(new User(null, "olga", "12345"));
        userStorage.save(new User(null, "sergey", "qwerty"));

        UserService userService = new UserService(new UserStorageRepositoryAdapter(userStorage));
        userService.findById(1L).ifPresent(System.out::println);
        userService.findById(2L).ifPresent(System.out::println);
        System.out.println("------------------------------");
    }
}
