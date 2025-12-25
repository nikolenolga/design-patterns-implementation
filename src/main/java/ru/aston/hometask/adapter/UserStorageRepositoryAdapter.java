package ru.aston.hometask.adapter;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserStorageRepositoryAdapter extends UserRepository {
    private final UserStorage userStorage;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStorage.getById(id));
    }

    @Override
    public Optional<User> create(User user) {
        return Optional.ofNullable(userStorage.save(user));
    }

    @Override
    public boolean delete(Long id) {
        return userStorage.remove(id);
    }
}
