package com.bhidi.crawler.beans;

import com.bhidi.crawler.controllers.HelloController;
import com.bhidi.crawler.foundations.ImgDownloader;

/**
 * Created by admin on 2017/8/3.
 */
public class TimeThread implements Runnable{
    private int i = 0;

    public static boolean switchCode = true;
    public boolean boo = false;
    @Override
    public void run() {
        while(switchCode){
            HelloController.map.put("numChange","false");
            boo = false;
            try {
                Thread.sleep(1000L);
                i++;
                System.out.println("i="+i);
            } catch (InterruptedException inte) {
            }
            if( i%60 == 0 ){
                boo = true;
            }
            if( boo ){
                HelloController.listNum.add( Show.getNum());
                if( HelloController.listNum.size() >= 2 && (int)HelloController.listNum.get(HelloController.listNum.size()-1) == (int)HelloController.listNum.get(HelloController.listNum.size()-2) ){
                    HelloController.map.put("numChange","true");
                    ImgDownloader.list1 = null;
                    TimeThread.switchCode = false;
                }
            }

        }
    }
}
