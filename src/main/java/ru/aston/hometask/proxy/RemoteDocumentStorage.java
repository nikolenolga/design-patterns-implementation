package ru.aston.hometask.proxy;

import ru.aston.hometask.strategy.Document;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class RemoteDocumentStorage implements DocumentRepository {
    private final AtomicLong idIncrementer = new AtomicLong();

    @Override
    public synchronized Optional<Document> getDocument(Long id) {
        connectToStorage();
        Document document = loadDocumentExample(id);
        disconnectFromStorage();
        return Optional.ofNullable(document);
    }

    @Override
    public synchronized Optional<Document> saveDocument(Document document) {
        connectToStorage();
        saveDocumentExample(document);
        disconnectFromStorage();
        return Optional.ofNullable(document);
    }

    private void connectToStorage() {
        System.out.println("Connected to remote document storage");
    }

    private void disconnectFromStorage() {
        System.out.println("Disconnect from remote document storage");
    }

    private Document loadDocumentExample(Long id) {
        Document document = new Document(id, "example.txt", "Document text.");
        System.out.printf("Document loaded: %s%n", document);
        return document;
    }

    private void saveDocumentExample(Document document) {
        document.setId(nextId());
        System.out.printf("Document saved: %s%n", document);
    }

    private Long nextId() {
        return idIncrementer.incrementAndGet();
    }
}
