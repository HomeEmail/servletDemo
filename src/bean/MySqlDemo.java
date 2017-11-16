package bean; /**
 * Created by ivan on 17/11/14.
 */

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.lang.*;

public class MySqlDemo {
    private static Properties pp = new Properties();

    //JDBC 驱动名及数据库url
    static String JDBC_DRIVER; // = "com.mysql.jdbc.Driver";
    static String DB_URL; // = "jdbc:mysql://localhost:3306/creditcard";//连接creditcard数据库


    //数据库的用户名和密码
    static String USER;// = "root";
    static String PASS;// = "123456";

    public MySqlDemo(ServletContext sc){
        String filePath;
        filePath=sc.getRealPath("/WEB-INF/dbConfig.properties");//返回路径就是网站发布的根路径加上传进去的路径字符串,使用这个会自动识别兼容不同系统的路径分隔符
        System.out.println("读取properties类型的配置文件");
        File fin=new File(filePath);
        if(fin.exists()){
            System.out.println("has file dbConfig.properties");
        }else {
            System.out.println("has not file dbConfig.properties");
        }
        try{
            pp.load(new FileInputStream(filePath));
        }catch (Exception e){
            System.out.println("read dbConfig.properties file fail");
        }
        JDBC_DRIVER=(String)pp.get("jdbc_driver");
        DB_URL="jdbc:mysql://"+pp.get("host")+":"+pp.get("port")+"/"+pp.get("dbName");
        USER=(String)pp.get("user");
        PASS=(String)pp.get("password");
    }
    public static void main(String[] args){


        ArrayList rs=exec(args);
    }
    public static ArrayList exec(String[] args){
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
            ResultSetMetaData   rsmd   =   rs.getMetaData();
            int   columnCount   =   rsmd.getColumnCount();
            ArrayList rows = new ArrayList();

            //展开结果集数据库 
            while (rs.next()){

                HashMap row=new HashMap();
                for(int i=1;   i<=columnCount; i++)   {
                    String   cname   =   rsmd.getColumnName(i);
                    row.put(cname,   rs.getObject(i));
                }
                rows.add(row);

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
            return  rows;
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
