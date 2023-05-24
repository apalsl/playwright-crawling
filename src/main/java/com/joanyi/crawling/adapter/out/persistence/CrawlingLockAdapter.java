package com.joanyi.crawling.adapter.out.persistence;

import com.joanyi.crawling.application.port.out.CrawlingLockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrawlingLockAdapter implements CrawlingLockPort {

    private final CrawlingRepository crawlingRepository;

    @Override
    public boolean existsCrawlingByUrl(String url) {
        return crawlingRepository.existsCrawlingByUrl(url);
    }
}
