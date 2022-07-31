package ru.netology.authorizationserviceappspringboot.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @NotBlank
    @Size(min = 2, max = 20)
    private final String name;
    @NotBlank
    @Size(min = 3, max = 8)
    private final String password;

    public User(String user, String password) {
        this.name = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        return "UserAuthorities{" +
                "user='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

