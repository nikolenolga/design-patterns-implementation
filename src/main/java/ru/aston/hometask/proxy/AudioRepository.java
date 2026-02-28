package ru.aston.hometask.proxy;

import java.util.Optional;

public interface AudioRepository {
    Optional<Audio> getAudio(Long id);

    Optional<Audio> saveAudio(Audio audio);
}
