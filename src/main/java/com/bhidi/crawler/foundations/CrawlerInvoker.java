package com.bhidi.crawler.foundations;

import com.bhidi.crawler.beans.Show;
import us.codecraft.webmagic.Spider;

/**
 * Created by zhy19712 on 28/07/2017.
 */
public class CrawlerInvoker {
    public void Invoke(){
        if(Show.isBoo() == false){

        }
        String fileStorePath = "download";
        String url = "http://www.creei.cn/";
        String urlPattern = "^((https|http|ftp|rtsp|mms)?:\\/\\/www.creei.cn[\\s\\S]*)";
        ImgProcessor imgspider=new ImgProcessor(url, urlPattern);

        Spider.create(imgspider)
                .addUrl(url)
                .addPipeline(new ImgPipeline(fileStorePath))
                .thread(5)
                .run();
    }
}
