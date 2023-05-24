package com.joanyi.crawling.adapter.in.web;

import com.joanyi.crawling.application.port.in.CrawlingCommand;
import com.joanyi.crawling.application.port.in.CrawlingUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
public class CrawlingController {

    private final CrawlingUseCase crawlingUseCase;

    @GetMapping("/test")
    public void startCrawling() {

        // args
        String site = "naver";
        String url = "www.naver.com";

        CrawlingCommand crawlingCommand = new CrawlingCommand(site, url);


        crawlingUseCase.start(crawlingCommand);
    }
}
