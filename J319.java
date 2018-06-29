package day6_21;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class J319 {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  //cj为最新的
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";

    static final String USER = "root";//用户名
    static final String PASS = "liwenwu.610";//密码
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

//----------------------------------------------------------------------------------------------------------------
            // 执行查询
            stmt = conn.createStatement();
            String sql;
            sql = "select * from t_user where regTime between '2017-8-10 10:20:30' and '2017-9-12 10:20:30'";//websites为数据库
            ResultSet rs = stmt.executeQuery(sql);
//----------------------------------------------------------------------------------------------------------------        
            //输出
            // 展开结果集数据库
            while(rs.next()){
                String username = rs.getString("username");
                String pwd = rs.getString("pwd");
                String regTime = rs.getString("regTime");
    
                // 输出数据
                System.out.print("username: " + username);
                System.out.print(", pwd: " + pwd);
                System.out.print(", regTime: " + regTime);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("End!");
    }
}
