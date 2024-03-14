package ru.kata.spring.boot_security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Сущность, представляющая пользователя в системе.
 * Реализует интерфейс UserDetails для интеграции с Spring Security.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity(name = "users")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;

    @ToString.Exclude
    private boolean enabled;

    @ManyToMany
    @ToString.Exclude
    private Set<Role> roles = new HashSet<>();

    public User(String username, String lastName, String email, String password) {
        this.username = username;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
        this.enabled = true;
    }

    /**
     * Возвращает коллекцию ролей, связанных с этим пользователем.
     * Этот метод необходим для интеграции с Spring Security.
     *
     * @return коллекция объектов, каждый из которых реализует GrantedAuthority
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    /**
     * Проверяет, не истек ли срок действия учетной записи пользователя.
     * Данную функцию я не реализовывал.
     *
     * @return true, если учетная запись не истекла
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Проверяет, не заблокирована ли учетная запись пользователя.
     * Данную функцию я не реализовывал.
     *
     * @return true, если учетная запись не заблокирована
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Проверяет, не истекли ли учетные данные пользователя.
     * Данную функцию я не реализовывал.
     *
     * @return true, если учетные данные не истекли
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Проверяет, активирован ли пользователь.
     * При создании User пользователь активирован по умолчанию.
     *
     * @return true, если пользователь активирован
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
