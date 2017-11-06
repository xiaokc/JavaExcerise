package dao;

import model.QAObj;

import java.sql.*;

/**
 * Created by xkc on 11/4/15.
 */
public class DB {
    private static String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/faq";
    private static final String username = "root";
    private static final String password = "123456";

    private static Connection conn = null;

    public static Connection getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void addData(QAObj qaObj) {
        Connection conn = getConn();

        PreparedStatement statement = null;
        String question = qaObj.getQuestion();
        String answer = qaObj.getAnswer();
        String sql = "insert into QA (id,question,answer) values(null,?,?)";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, question);
            statement.setString(2, answer);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static String searchAnsByQue(String question) {
        Connection conn = getConn();
        PreparedStatement statement = null;
        String sql = "select answer from QA where question=?";
        ResultSet rs = null;
        String answer = null;

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, question);
            rs = statement.executeQuery();
            while (rs.next()) {
                answer = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static ResultSet searchAll() {
        Connection conn = getConn();
        PreparedStatement statement = null;
        String sql = "select * from QA";
        ResultSet rs = null;

        try {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rs;
    }

}
