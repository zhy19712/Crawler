package com.bhidi.crawler.controllers;

import com.alibaba.fastjson.JSON;
import com.bhidi.crawler.beans.Show;
import com.bhidi.crawler.beans.TimeThread;
import com.bhidi.crawler.foundations.CrawlerInvoker;
import com.bhidi.crawler.foundations.ImgDownloader;
import com.bhidi.crawler.utils.add;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by zhy19712 on 28/07/2017.
 */
@Controller
public class HelloController {
    private static List<Object> list = new ArrayList<Object>();
    public static List<Integer> listNum = new ArrayList<Integer>();
    private static int i =0;
    public static Map<String,String> map = new HashMap<String, String>();

    private CrawlerInvoker craw;

    @ResponseBody
    @RequestMapping(value = "/start", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String printHello(@RequestParam(value = "name",required = false) String name, ModelMap model,HttpSession session)  {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "gg!");
        add aaa = new add(1,2);


        //设置爬出来的数量
        Show.setNum(0);
        //清空爬出来的数据的集合
        ImgDownloader.list1.clear();
        //设置打印开关
        ImgDownloader.bbb = true;

        //创建一个新的爬虫
        CrawlerInvoker craw = new CrawlerInvoker();
        //放入爬虫集合，
        list.add(craw);

        try{
            Thread.sleep(1000);
        }catch(Exception e){

        }

        //开启时间线程
        TimeThread.switchCode = true;
        TimeThread timeTh = new TimeThread();
        Thread timeThread =  new Thread(timeTh);
        timeThread.start();

        //取出来爬虫集合的最后一个数据，启动
        CrawlerInvoker craw2 = (CrawlerInvoker)list.get(list.size() - 1);
        craw2.Invoke();

        //返回值的设置
        String sign = "normal";
        sign = (String)session.getAttribute("sign");
        Map<String,String> map1 = new HashMap<String, String>();
        map1.put("sign",sign);
        String json = JSON.toJSONString(map1);
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String printData(ModelMap model)  {
        //取出来爬出来的数量
        String numStr = Integer.toString(Show.getNum());
        //取出来爬出来的数据的后五位
        String jsonString = JSON.toJSONString(Show.getList());
        map.put("str",jsonString);
        map.put("number",numStr);
        String json = JSON.toJSONString(map);
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/stop", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String stopThread(ModelMap model, HttpSession session)  {
        //取出来我们想要停掉的爬虫
        CrawlerInvoker craw2 = (CrawlerInvoker)list.get(list.size() - 1);
        craw2.stop();

        session.setAttribute("sign","interrupt");
        //设置时间线程的开关
        TimeThread.switchCode = false;
        //清空爬出来的数据的集合
        ImgDownloader.list1.clear();
        //设置爬出来的数据的个数为0
        Show.setNum(0);
        //设置爬虫打印的开关
        ImgDownloader.bbb = false;



        return "json";
    }
}

