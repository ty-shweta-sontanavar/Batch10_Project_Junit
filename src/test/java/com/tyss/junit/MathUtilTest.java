package com.tyss.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilTest 
{
    //private MathUtil mathutil;
	@Test
	@DisplayName("add numbers")
	void testAddNumbers() 
	{
	   MathUtil mathUtil=new MathUtil();
	   int exp=10;
	   int act=mathUtil.addNumbers(5, 5);
	   System.out.println("success");
	   assertEquals(exp, act,"exp is not equal to actual");
	}
   
	@Test
	void testDivideNumbers()
	{
		MathUtil mathUtil=new MathUtil();
		
		assertThrows(ArithmeticException.class, ()->mathUtil.DivideNumbers(10, 0));
	}
	
	@Test
	void AreaOfCircle()
	{
		MathUtil mathUtil=new MathUtil();
		double exp= 78.55;
	     double act= mathUtil.AreaOfCircle(5);
		 assertEquals(exp, act, "exp is equal to actual");
	}
}
