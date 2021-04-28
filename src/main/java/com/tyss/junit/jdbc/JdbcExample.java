package com.tyss.junit.jdbc;

import java.util.ArrayList;

public interface JdbcExample 
{
   public void insert(int uid,String uname);
   
   public ArrayList<Object> select();
 
   public void update(int uid,String uname);
   
   public void delete(int uid);
   
   
}
