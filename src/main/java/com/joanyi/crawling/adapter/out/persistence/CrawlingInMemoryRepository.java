package com.joanyi.crawling.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class CrawlingInMemoryRepository implements CrawlingRepository {

    private final ConcurrentMap<String, String> store = new ConcurrentHashMap<>();

    @Override
    public boolean existsCrawlingByUrl(String url) {
        return store.get(url) != null;
    }
}
