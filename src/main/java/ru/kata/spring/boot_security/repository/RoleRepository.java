package ru.kata.spring.boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.model.Role;

/**
 * Репозиторий для работы с сущностями Role в базе данных.
 * Наследуется от JpaRepository для использования встроенных методов работы с базой данных.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
