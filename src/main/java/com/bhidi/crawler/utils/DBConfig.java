package com.bhidi.crawler.utils;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhy19712 on 01/08/2017.
 */
public class DBConfig {
    public static final String url = "jdbc:mysql://127.0.0.1/Crawler";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "admin";
    public ServletContext application;


    public DBConfig(ServletContext application) {
        this.application = application;
        try {
            Class.forName(name);//指定连接类型
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}



