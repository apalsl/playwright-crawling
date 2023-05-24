package com.joanyi.crawling.application.service;

import com.joanyi.crawling.application.port.in.CrawlingCommand;
import com.joanyi.crawling.application.port.in.CrawlingUseCase;
import com.joanyi.crawling.application.port.out.CrawlingLockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrawlingService implements CrawlingUseCase {

    private final CrawlingLockPort crawlingLockPort;

    @Override
    public void start(CrawlingCommand crawlingCommand) {

        isRunnable(crawlingCommand);


    }

    private void isRunnable(CrawlingCommand crawlingCommand) {
        if (crawlingLockPort.existsCrawlingByUrl(crawlingCommand.getUrl())) {
            throw new IllegalStateException(crawlingCommand.getUrl() + "은 이미 실행중입니다.");
        }
    }

}
