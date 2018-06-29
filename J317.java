package day6_21;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class J317 {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  //cj为最新的
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/db?"
    		+ "useUnicode=true&characterEncoding=utf-8&"
    		+ "useSSL=false&serverTimezone=UTC&"
    		+ "rewriteBatchedStatements=true";//批量上传的前提
    static final String USER = "root";//用户名
    static final String PASS = "liwenwu.610";//密码
 
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
//-------------------------------------------------------------------------------
            String sql;
            sql = "INSERT INTO t_user (username,pwd,regTime)VALUES(?,?,?)";//websites为数据库
            PreparedStatement ps= conn.prepareStatement(sql);
            Long startTime = System.currentTimeMillis();//计时开始
            for(int i=0;i<2000;i++) {
            	ps.setString(1, "user_"+i);
            	ps.setString(2, "mima_"+i);
            	ps.setDate(3, new Date(new java.util.Date().getTime()));
            	ps.executeUpdate();
            }
//-------------------------------------------------------------------------------            
            Long endTime = System.currentTimeMillis();//计时结束
            System.out.println("OK,用时：" + (endTime - startTime)); 
            //输出
/*            String print = "SELECT id,username,pwd,regTime FROM t_user";
            ResultSet rs = stmt.executeQuery(print);
            while(rs.next()) {
            	System.out.print("id:"+rs.getInt("id"));
                System.out.print(",username: " + rs.getString("username"));
                System.out.print(", pwd: " + rs.getString("pwd"));
                System.out.print(", regTime: " + rs.getDate("regTime"));
                System.out.print("\n");
            }
            rs.close();*/
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
