package com.bhidi.crawler.utils;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhy19712 on 01/08/2017.
 */
public class DBTest {

    static String sql = null;
    static ResultSet ret = null;
    static Statement stmt = null;
    public static ServletContext application;



    public static void main(String[] args) {
        sql = "select * from CONTENT";//SQL语句
        Connection conn = new DBConfig(application).getConn();

        try {
            stmt = conn.createStatement();

            ret = stmt.executeQuery(sql);//执行语句，得到结果集
            while (ret.next()) {
                String TITLE = ret.getString(3);
                String PATH = ret.getString(4);
                String TYPE = ret.getString(5);
                System.out.println(TITLE + "\t" + PATH + "\t" + TYPE);
            }//显示数据
            ret.close();
            conn.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


