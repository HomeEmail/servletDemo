/**
 * Created by ivan on 17/11/14.
 */

import java.sql.*;

public class MySqlDemo {
    //JDBC 驱动名及数据库url
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/creditcard";//连接creditcard数据库 
    
    //数据库的用户名和密码
    static final String USER = "root";
    static final String PASS = "123456";
    public static void main(String[] args){
        ResultSet rs=exec(args);
    }
    public static ResultSet exec(String[] args){
        Connection conn = null;
        Statement stmt = null;
        try{
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);
            
            //打开连接
            System.out.println("连接数据库...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            
            //执行查询
            System.out.println("实例化Statement 对象...");
            stmt=conn.createStatement();
            String sql;
            sql="select id,username,pwd,email,contact,name,address,identificationNo from user";
            ResultSet rs=stmt.executeQuery(sql);
            
            //展开结果集数据库 
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String name = rs.getString("name");
                
                System.out.print("id: "+id);
                System.out.print(", username: "+username);
                System.out.print(", email: "+email);
                System.out.print(", name: "+name);
                
                System.out.print("\n");
                
            }
            rs.close();
            stmt.close();
            conn.close();
            return  rs;
        }catch (SQLException se){
            //处理jdbc错误
            se.printStackTrace();
        }catch (Exception e){
            //处理Class.forName错误
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch (SQLException se2){
                
            }
            try{
                if(conn!=null) conn.close();
            }catch (SQLException se3){
                se3.printStackTrace();
            }

        }
        System.out.println("Goodbye!");
        return null;
    }
}
