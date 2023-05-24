package com.joanyi.crawling.application.service;

import com.joanyi.crawling.application.port.in.CrawlingCommand;
import com.joanyi.crawling.application.port.out.CrawlingLockPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CrawlingServiceTest {

    @InjectMocks
    CrawlingService crawlingService;

    @Mock
    CrawlingLockPort crawlingLockPort;

    @Test
    void 실행중인_URL_중복실행_불가능() {
        CrawlingCommand crawlingCommand = new CrawlingCommand("naver", "www.naver.com");

        given(crawlingLockPort.existsCrawlingByUrl(any())).willReturn(true);

        Assertions.assertThatThrownBy(() -> crawlingService.start(crawlingCommand))
                        .isInstanceOf(IllegalStateException.class);
    }



}