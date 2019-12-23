package br.avcaliani.cache.job;

import br.avcaliani.cache.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static br.avcaliani.cache.util.TimeUtil.sleep;

@Slf4j
@Component
public class CheckUserJob implements CommandLineRunner {

    @Value("${app.job.repeat}")
    private int times;

    @Value("${app.job.delay}")
    private long delay;

    @Autowired
    private UserService service;

    @Override
    public void run(String... args) {

        log.info("Starting 'Main Job' \\o/");

        for (int i = 0; i < times; i++) {
            log.info("Execution {} started...", i);
            service.find().forEach(
                    user -> log.info("User -> {}", user.toString())
            );
            log.info("Execution {} finished ;)", i);
            sleep(delay);
        }

        log.info("Bye bye...");
    }

}
