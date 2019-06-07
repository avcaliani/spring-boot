package br.avcaliani.cache.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheScheduler {

    private static final Logger L = LoggerFactory.getLogger(CacheScheduler.class);

    @Value("${app.cache.detailed.report}")
    private boolean detailedReport;

    @Autowired
    private CacheManager manager;

    @Scheduled(fixedRate = 10000)
    public void clear() {

        L.info("Cleaning caches...");

        manager.getCacheNames().stream().forEach(name -> {
            if (detailedReport) detailed(name);
            else simplified(name);
        });

        L.info("All caches have already been cleaned \\o/");
    }

    private void simplified(String name) {

        Cache cache = manager.getCache(name);
        if (cache == null)
            return;

        cache.clear();
        L.info("[OK] '{}' (? -> ?)", name);
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

        L.info("[OK] '{}' ({} -> {})", name, cached, cmc.getNativeCache().size());
    }

}
