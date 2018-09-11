package com.cx.bank.util;

import java.sql.*;

public class DB {

    /**
     * 连接数据库
     * @return
     */
    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankuser?useSSL=false&user=root&password=ryanxiang");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }



    /**
     * 关闭数据库
     * @param conn
     */
    public static void closeConn(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭操作
     * @param stmt
     */
    public static void closeStmt(Statement stmt){
        try{
            if (stmt != null){
                stmt.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 关闭结果集
     * @param res
     */
    public static void closeRes(ResultSet res){
        try {
            if(res != null){
                res.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
