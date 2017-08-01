package com.bhidi.crawler.beans;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by admin on 2017/8/1.
 */
@Repository
public class Show {
    private static List<String> list;

    public Show(){}

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        Show.list = list;
    }
}
