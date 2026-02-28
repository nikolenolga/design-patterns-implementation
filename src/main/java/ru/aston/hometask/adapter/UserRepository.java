package ru.aston.hometask.adapter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private final Map<Long, User> repository = new ConcurrentHashMap<>();
    private final AtomicLong idIncrementer = new AtomicLong();

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    public Optional<User> create(User user) {
        Long id = nextId();
        user.setId(id);
        repository.put(id, user);
        return Optional.of(user);
    }

    public boolean delete(Long id) {
        if (repository.containsKey(id)) {
            repository.remove(id);
            return true;
        }
        return false;
    }

    private Long nextId() {
        return idIncrementer.incrementAndGet();
    }
}
