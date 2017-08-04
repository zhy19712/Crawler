package com.bhidi.crawler.utils;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhy19712 on 04/08/2017.
 */
public class DBUtils {

    public DBUtils(){}

    public static void Insert(String sql){
        Statement stmt = null;
        ServletContext application = null;
        Connection conn = new DBConfig(application).getConn();
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

