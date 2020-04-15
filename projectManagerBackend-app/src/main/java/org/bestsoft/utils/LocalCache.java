package org.bestsoft.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Component
public class LocalCache {
    Cache<String, Object> cache;

    @PostConstruct
    private void init() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(60, TimeUnit.SECONDS)
                .build();
    }

    public void put(String k, Object v) {
        this.cache.put(k, v);
    }

    public Object get(String k) {
        try {
            return this.cache.get(k, new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return null;
                }
            });
        } catch (Exception e) {
            return null;
        }
    }
}
