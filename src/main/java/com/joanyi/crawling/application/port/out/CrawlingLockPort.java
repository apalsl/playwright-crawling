package com.joanyi.crawling.application.port.out;

public interface CrawlingLockPort {
    boolean existsCrawlingByUrl(String url);
}
