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
        Show.setNum(0);
        ImgDownloader.list1 = new ArrayList();
        CrawlerInvoker craw = new CrawlerInvoker();
        list.add(craw);

        ImgDownloader.bbb = true;
        //开启时间线程
        TimeThread.switchCode = true;
        TimeThread timeTh = new TimeThread();
        Thread timeThread =  new Thread(timeTh);
        timeThread.start();

        CrawlerInvoker craw2 = (CrawlerInvoker)list.get(list.size() - 1);
        craw2.Invoke();

        model.addAttribute("return","nihao");
        String sign = "normal";
        sign = (String)session.getAttribute("sign");

        Map<String,String> map = new HashMap<String, String>();
        map.put("sign",sign);



        String json = JSON.toJSONString(map);
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String printData(ModelMap model)  {

        String numStr = Integer.toString(Show.getNum());
        String jsonString = JSON.toJSONString(Show.getList());

        map.put("str",jsonString);
        map.put("number",numStr);



        String json = JSON.toJSONString(map);

       /* char[] chars = new char[2];
        response.setCharacterEncoding("UTF-8");
        try{
            response.getWriter().write(chars);
        }catch(IOException e){
            System.out.println("response报错！");
        }
        try {
            response.getWriter().close();
        }catch(IOException e){
            System.out.println("response报错！");
        }*/

        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/stop", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String stopThread(ModelMap model, HttpSession session)  {
        CrawlerInvoker craw2 = (CrawlerInvoker)list.get(list.size() - 1);
        session.setAttribute("sign","interrupt");

        craw2.stop();
        TimeThread.switchCode = false;
        ImgDownloader.list1 = null;
        ImgDownloader.bbb = false;


        return "json";
    }
}

