package ru.aston.hometask.proxy;

import lombok.AllArgsConstructor;
import ru.aston.hometask.strategy.Document;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class DocumentCacheProxy implements DocumentRepository {
    private final Map<Long, Document> DOCUMENT_CACHE = new ConcurrentHashMap<>();
    private RemoteDocumentStorage remoteDocumentStorage;

    @Override
    public Optional<Document> getDocument(Long id) {
        if (isCached(id)) {
            System.out.println("Get cached document");
            return Optional.ofNullable(getCached(id));
        }
        return remoteDocumentStorage.getDocument(id);
    }

    @Override
    public Optional<Document> saveDocument(Document document) {
        Optional<Document> documentOptional = remoteDocumentStorage.saveDocument(document);
        if (documentOptional.isPresent()) {
            Document savedDocument = documentOptional.get();
            DOCUMENT_CACHE.put(savedDocument.getId(), savedDocument);
            System.out.println("Document saved to cache");
        }
        return documentOptional;
    }

    private boolean isCached(Long id) {
        return DOCUMENT_CACHE.containsKey(id);
    }

    private Document getCached(Long id) {
        return DOCUMENT_CACHE.get(id);
    }
}
