package com.bhidi.crawler.controllers;

import com.alibaba.fastjson.JSON;
import com.bhidi.crawler.beans.Show;
import com.bhidi.crawler.foundations.CrawlerInvoker;
import com.bhidi.crawler.foundations.ImgDownloader;
import com.bhidi.crawler.utils.add;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhy19712 on 28/07/2017.
 */
@Controller

public class HelloController {


    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String printHello(ModelMap model)  {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "gg!");
        add aaa = new add(1,2);
        CrawlerInvoker ccc = new CrawlerInvoker();
        ccc.Invoke();
        model.addAttribute("return","nihao");
        Map<String,String> map = new HashMap<String, String>();
        map.put("str","end");
        String json = JSON.toJSONString(map);
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/data", method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public String printData(ModelMap model)  {

        List<String> list = Show.getList();
        int num = Show.getNum();
        String numStr = Integer.toString(num);

        String jsonString = JSON.toJSONString(list);

        Map<String,String> map = new HashMap<String, String>();

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

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public String stopThread(ModelMap model)  {
        Show.setBoo(false);
        return "json";
    }
}

