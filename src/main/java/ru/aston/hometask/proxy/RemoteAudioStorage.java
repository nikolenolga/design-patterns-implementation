package ru.aston.hometask.proxy;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class RemoteAudioStorage implements AudioRepository {
    private final AtomicLong idIncrementer = new AtomicLong();

    @Override
    public synchronized Optional<Audio> getAudio(Long id) {
        connectToStorage();
        Audio audio = loadAudioExample(id);
        disconnectFromStorage();
        return Optional.ofNullable(audio);
    }

    @Override
    public synchronized Optional<Audio> saveAudio(Audio audio) {
        connectToStorage();
        saveAudioExample(audio);
        disconnectFromStorage();
        return Optional.ofNullable(audio);
    }

    private void connectToStorage() {
        System.out.println("Connected to remote audio storage");
    }

    private void disconnectFromStorage() {
        System.out.println("Disconnect from remote audio storage");
    }

    private Audio loadAudioExample(Long id) {
        Audio audio = new Audio(id, "song.mp3", new byte[0]);
        System.out.printf("Audio loaded: %s%n", audio);
        return audio;
    }

    private void saveAudioExample(Audio audio) {
        audio.setId(nextId());
        System.out.printf("Audio saved: %s%n", audio);
    }

    private Long nextId() {
        return idIncrementer.incrementAndGet();
    }
}
