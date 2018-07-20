package br.avcaliani.secureskeleton.user.services.impl;

import br.avcaliani.secureskeleton.user.model.entities.User;
import br.avcaliani.secureskeleton.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private static final Set<User> USERS;

    @Autowired
    private BCryptPasswordEncoder encoder;

    static {
        USERS = new HashSet<>();
    }

    @Override
    public User save(User user) throws Exception {

        if (user == null || user.getUsername() == null || user.getPassword() == null)
            throw new Exception("Invalid user data!");

        user.setId(UUID.randomUUID());
        user.setPassword(encoder.encode(user.getPassword()));

        if (!USERS.add(user))
            throw new Exception("User already exists!");

        return user;
    }

}
