package ru.aston.hometask.adapter;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> create(User user) {
        return userRepository.create(user);
    }

    public boolean delete(Long id) {
        return userRepository.delete(id);
    }
}
