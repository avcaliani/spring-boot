package br.avcaliani.cache.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CacheScheduler {

    @Value("${app.cache.detailed.report}")
    private boolean detailedReport;

    @Autowired
    private CacheManager manager;

    @Scheduled(fixedRate = 10000)
    public void clear() {

        log.info("Cleaning caches...");

        manager.getCacheNames().stream().forEach(name -> {
            if (detailedReport) detailed(name);
            else simplified(name);
        });

        log.info("All caches have already been cleaned \\o/");
    }

    private void simplified(String name) {

        Cache cache = manager.getCache(name);
        if (cache == null)
            return;

        cache.clear();
        log.info("[OK] '{}' (? -> ?)", name);
    }


    private void detailed(String name) {

        Cache cache = manager.getCache(name);
        if (!(cache instanceof ConcurrentMapCache)) {
            simplified(name);
            return;
        }

        ConcurrentMapCache cmc = (ConcurrentMapCache) cache;
        int cached = cmc.getNativeCache().size();

        cmc.clear();

        log.info("[OK] '{}' ({} -> {})", name, cached, cmc.getNativeCache().size());
    }

}
