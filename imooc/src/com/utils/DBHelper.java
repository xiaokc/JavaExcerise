package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用JDBC实现DBHelper类
 * Created by xkc on 8/20/15.
 */
public class DBHelper {

    private static final String driver = "com.mysql.jdbc.Driver";//数据库驱动
    //连接数据库的url
    private static final String url = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "root";//数据库的用户名
    private static final String password = "123456";//数据库的密码

    private static Connection conn = null;

    //静态代码块负责加载驱动
    static {
        try {
            Class.forName(driver);
            System.out.print("数据库驱动加载成功！");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //单例模式返回一个数据库连接对象
    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, username, password);

                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return conn;
    }

    public static void main(String[] args) {
        Connection conn = DBHelper.getConnection();
        if (conn != null) {
            System.out.print("数据库连接成功");
        } else {
            System.out.print("数据库连接失败");
        }

    }


}
