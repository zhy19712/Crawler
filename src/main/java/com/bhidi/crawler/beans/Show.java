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
    private static int num;
    private static boolean boo;

    public Show(){}


    public static boolean isBoo() {
        return boo;
    }

    public static void setBoo(boolean boo) {
        Show.boo = boo;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Show.num = num;
    }

    public static List<String> getList() {
        return list;
    }

    public static void setList(List<String> list) {
        Show.list = list;
    }
}
