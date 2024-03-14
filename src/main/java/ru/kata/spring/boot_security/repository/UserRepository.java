package ru.kata.spring.boot_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.model.User;

/**
 * Репозиторий для работы с сущностями User в базе данных.
 * Наследуется от JpaRepository для использования встроенных методов работы с базой данных.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
