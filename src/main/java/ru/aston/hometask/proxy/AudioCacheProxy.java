package ru.aston.hometask.proxy;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class AudioCacheProxy implements AudioRepository {
    private final Map<Long, Audio> DOCUMENT_CACHE = new ConcurrentHashMap<>();
    private RemoteAudioStorage remoteAudioStorage;

    @Override
    public Optional<Audio> getAudio(Long id) {
        if (isCached(id)) {
            System.out.println("Get cached audio");
            return Optional.ofNullable(getCached(id));
        }
        return remoteAudioStorage.getAudio(id);
    }

    @Override
    public Optional<Audio> saveAudio(Audio audio) {
        Optional<Audio> audioOptional = remoteAudioStorage.saveAudio(audio);
        if (audioOptional.isPresent()) {
            Audio savedAudio = audioOptional.get();
            DOCUMENT_CACHE.put(savedAudio.getId(), savedAudio);
            System.out.println("Audio saved to cache");
        }
        return audioOptional;
    }

    private boolean isCached(Long id) {
        return DOCUMENT_CACHE.containsKey(id);
    }

    private Audio getCached(Long id) {
        return DOCUMENT_CACHE.get(id);
    }
}
