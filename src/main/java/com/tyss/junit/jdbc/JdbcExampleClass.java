package com.tyss.junit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcExampleClass implements JdbcExample
{

	@Override
	public void insert(int uid, String uname) 
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
		String query="insert into student values(?,?)";
		PreparedStatement pm=con.prepareStatement(query);
		pm.setInt(1, uid);
		pm.setString(2,uname);
		pm.execute();
		con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Object> select() 
	{
		ArrayList<Object> obj=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
			String query="select * from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			obj=new ArrayList<Object>();
			while(rs.next())
			{
				int i1=rs.getInt("id");
				obj.add(i1);
				String s1=rs.getString("name");
				obj.add(s1);
				con.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void update(int uid, String uname) 
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
		String query="update student set name=? where id=?";
		PreparedStatement pm=con.prepareStatement(query);
		pm.setString(1,uname);
		pm.setInt(2, uid);
		pm.execute();
		con.close();
	}catch(Exception e)
		{
		e.printStackTrace();
		}
	}

	@Override
	public void delete(int uid) 
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
		String query="delete from student where id=?";
		PreparedStatement pm=con.prepareStatement(query);
		pm.setInt(1, uid);
		pm.execute();
		con.close();
		}catch(Exception e)
		{
			
		}
		
	}

}
