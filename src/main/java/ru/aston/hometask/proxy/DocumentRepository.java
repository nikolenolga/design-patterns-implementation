package ru.aston.hometask.proxy;

import ru.aston.hometask.strategy.Document;

import java.util.Optional;

public interface DocumentRepository {
    Optional<Document> getDocument(Long id);

    Optional<Document> saveDocument(Document document);
}
