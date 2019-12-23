package br.avcaliani.cache.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static br.avcaliani.cache.util.TimeUtil.sleep;

@Repository
public class UserRepository implements Serializable {

    @Value("${app.repository.delay}")
    private long delay;

    @Cacheable("user.list")
    public List<User> find() {

        List<User> users = new ArrayList<>();
        users.add(new User("Anthony", "anthony@mail.com"));
        users.add(new User("Joe", "Joe@mail.com"));

        sleep(delay);
        return users;
    }

}
