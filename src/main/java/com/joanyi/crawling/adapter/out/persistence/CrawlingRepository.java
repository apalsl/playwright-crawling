package com.joanyi.crawling.adapter.out.persistence;

public interface CrawlingRepository {
    boolean existsCrawlingByUrl(String url);
}
