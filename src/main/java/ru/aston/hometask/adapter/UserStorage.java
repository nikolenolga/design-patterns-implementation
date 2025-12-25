package ru.aston.hometask.adapter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UserStorage {
    private final Map<Long, User> repository = new ConcurrentHashMap<>();
    private final AtomicLong idIncrementer = new AtomicLong();

    public User getById(Long id) {
        return repository.get(id);
    }

    public User save(User user) {
        Long id = nextId();
        user.setId(id);
        return repository.put(id, user);
    }

    public boolean remove(Long id) {
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
