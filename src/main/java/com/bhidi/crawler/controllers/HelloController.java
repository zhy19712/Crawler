package com.bhidi.crawler.controllers;

import com.bhidi.crawler.foundations.*;
import com.bhidi.crawler.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhy19712 on 28/07/2017.
 */
@Controller

public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "gg!");
        add aaa = new add(1,2);
        CrawlerInvoker ccc = new CrawlerInvoker();
        ccc.Invoke();
        System.out.println(aaa.plus());

        return "hello";
    }
}