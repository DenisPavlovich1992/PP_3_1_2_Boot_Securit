package ru.kata.spring.boot_security.service;

import ru.kata.spring.boot_security.model.User;

import java.util.List;

/**
 * Сервисный интерфейс для работы с пользователями (User).
 */
public interface UserService {

    void add(User user);

    void update(User user);

    void delete(Long id);

    List<User> getAllUsers();

    String getUserRoles(User user);

    void addRoleToUser(String roleName, User user);

    User findByUsername(String username);

    User findById(Long id);

}
