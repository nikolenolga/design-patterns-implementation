package ru.aston.hometask.proxy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AudioService {
    private AudioRepository audioRepository;

    public Audio downloadAudio(Long id) {
        return audioRepository.getAudio(id).orElseThrow(() -> new RuntimeException("Audio not found: %s".formatted(id)));
    }

    public Audio saveAudio(Audio audio) {
        return audioRepository.saveAudio(audio).orElseThrow(() -> new RuntimeException("Audio not saved: %s".formatted(audio)));
    }
}
