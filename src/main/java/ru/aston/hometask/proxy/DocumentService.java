package ru.aston.hometask.proxy;

import lombok.AllArgsConstructor;
import ru.aston.hometask.strategy.Document;

@AllArgsConstructor
public class DocumentService {
    private DocumentRepository userRepository;

    public Document downloadDocument(Long id) {
        return userRepository.getDocument(id).orElseThrow(() -> new RuntimeException("Document not found: %s".formatted(id)));
    }

    public Document saveDocument(Document document) {
        return userRepository.saveDocument(document).orElseThrow(() -> new RuntimeException("Document not saved: %s".formatted(document)));
    }

}
