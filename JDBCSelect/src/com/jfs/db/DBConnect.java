package com.jfs.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	//why it is string
	//why it is array
	//int, float, char, string
	//java DBConnect 10 kasi 98.5 
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//Register the jdbc driver
			//For Mysql
			//sasikala comment
			Class.forName("com.mysql.cj.jdbc.Driver");
			//For Oracle
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Create a connection
			//mysql database
			conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jfs_21","root","root");//url,username,password
			//Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Admin@123");//url,username,password  for oracle
			if(conn!=null) {
				stmt= conn.createStatement();
				
				String query="select * from emp";
				if(stmt!=null) {
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
//					    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));	//using index
					    System.out.println(rs.getInt("empno")+" "+rs.getString("sal")+" "+rs.getString("job"));	//using columnname
					}
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
