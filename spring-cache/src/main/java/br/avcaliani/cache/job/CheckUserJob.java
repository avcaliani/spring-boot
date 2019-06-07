package br.avcaliani.cache.job;

import br.avcaliani.cache.modules.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckUserJob implements CommandLineRunner {

    private static final Logger L = LoggerFactory.getLogger(CheckUserJob.class);

    @Value("${app.job.repeat}")
    private int times;

    @Value("${app.job.delay}")
    private int delay;

    @Autowired
    private UserService service;

    @Override
    public void run(String... args) throws Exception {

        L.info("Starting 'Main Job' \\o/");

        for (int i = 0; i < times; i++) {
            L.info("Execution {} started...", i);
            service.find().stream().forEach(
                    user -> L.info("User -> {}", user.toString())
            );
            L.info("Execution {} finished ;)", i);
            sleep();
        }

        L.info("Bye bye...");
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
