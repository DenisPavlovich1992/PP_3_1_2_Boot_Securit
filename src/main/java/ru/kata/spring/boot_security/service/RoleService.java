package ru.kata.spring.boot_security.service;

import ru.kata.spring.boot_security.model.Role;

/**
 * Сервисный интерфейс для работы с ролями (Role).
 */
public interface RoleService {

    Role findByName(String name);

}
