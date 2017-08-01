package com.bhidi.crawler.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhy19712 on 01/08/2017.
 */
public class DBTest {

    static String sql = null;
    static DBConfig db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select * from CONTENT";//SQL语句
        db1 = new DBConfig(sql);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                String TITLE = ret.getString(3);
                String PATH = ret.getString(4);
                String TYPE = ret.getString(5);
                System.out.println(TITLE + "\t" + PATH + "\t" + TYPE);
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

