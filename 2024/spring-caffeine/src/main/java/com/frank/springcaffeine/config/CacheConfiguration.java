package com.frank.springcaffeine.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * https://cloud.tencent.com/developer/article/1446606
 */
@Configuration
@ConfigurationProperties(prefix = "caching")
@Data
@Slf4j
@Component
public class CacheConfiguration {
//    caching.specs.student.timeout=2
//    caching.specs.person.timeout=10
    @Data
    public static class CacheSpec {
        private Integer timeout;
        private Integer max = 200;
    }

    private Map<String, CacheSpec> specs;

    @Bean
    public CacheManager cacheManager(Ticker ticker) {
        SimpleCacheManager manager = new SimpleCacheManager();
        if (specs != null) {
            List<CaffeineCache> caches =
                    specs.entrySet().stream()
                            .map(entry -> buildCache(entry.getKey(),
                                    entry.getValue(),
                                    ticker))
                            .collect(Collectors.toList());
            manager.setCaches(caches);
        }
        return manager;
    }

    private CaffeineCache buildCache(String name, CacheSpec cacheSpec, Ticker ticker) {
        log.info("Cache {} specified timeout of {} min, max of {}", name, cacheSpec.getTimeout(), cacheSpec.getMax());
        final Caffeine<Object, Object> caffeineBuilder
                = Caffeine.newBuilder()
                .expireAfterWrite(cacheSpec.getTimeout(), TimeUnit.SECONDS)
                .maximumSize(cacheSpec.getMax())
                .ticker(ticker);
        return new CaffeineCache(name, caffeineBuilder.build());
    }

    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
