package com.tyss.junit.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JdbcExampleClassTest {

	@Test
	void testInsert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
			JdbcExampleClass jc=new JdbcExampleClass();
			jc.insert(1,"shweta");
			String query="select * from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			assertEquals(1, rs.getInt(1));
			assertEquals("shweta",rs.getString(2));
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	void testSelect() 
	{
		JdbcExampleClass jc=new JdbcExampleClass();
		ArrayList<Object> obj=jc.select();
		assertEquals(obj!=null,false);
	}

	@Test
	void testUpdate() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
			JdbcExampleClass jc=new JdbcExampleClass();
			jc.update(1, "kaveri");
			String query="select * from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			assertEquals("kaveri", rs.getString(2));
			con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	@Test
	void testDelete() 
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/besm28?user=root&password=root");
		JdbcExampleClass jc=new JdbcExampleClass();
		jc.delete(1);
		String query="select * from student";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		assertEquals(rs.next(), false);
		con.close();
		
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
