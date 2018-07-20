package br.avcaliani.secureskeleton.user.model.entities;

import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String username;
    private String password;

    public User() {
    }

    public User(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

}
