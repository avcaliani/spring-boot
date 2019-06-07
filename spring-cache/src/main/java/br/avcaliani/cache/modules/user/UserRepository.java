package br.avcaliani.cache.modules.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Value("${app.repository.delay}")
    private long delay;

    @Cacheable("user.list")
    public List<User> find() {

        List users = new ArrayList<User>();
        users.add(new User("Anthony", "anthony@mail.com"));
        users.add(new User("Joe", "Joe@mail.com"));

        sleep();

        return users;
    }

    private void sleep() {
        try {
            if (delay <= 0) return;
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            return;
        }
    }

}
