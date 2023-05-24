package com.joanyi.crawling.application.port.in;

import lombok.Getter;

@Getter
public class CrawlingCommand {

    private String site;
    private String url;

    public CrawlingCommand(String site, String url) {
        this.site = site;
        this.url = url;
    }
}
