package com.bhidi.crawler.foundations;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by admin on 2017/7/17.
 */
public class ImgProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(10).setSleepTime(1000);
    private String url = "";
    private String urlPattern;

    public ImgProcessor(String url, String urlPattern){
        this.url = url;
        this.urlPattern= urlPattern;
    }
    @Override
    public void process(Page page) {

        List<String> requests = page.getHtml().links().regex(urlPattern).all();
        List<String> listBackSrc = page.getHtml().$("#mainContent_news .img_contaner>img","src").all();
        List<String> listBackTitle = page.getHtml().$("#mainContent_news .img_contaner>.img_title","text").all();
       /* System.out.println(listBackSrc);*/

        page.putField("src",listBackSrc);
        page.putField("title",listBackTitle);
        page.addTargetRequests(requests);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
