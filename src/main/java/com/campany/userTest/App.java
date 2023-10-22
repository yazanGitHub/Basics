package com.campany.userTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	public static double  [] Basic = {500.2d,200,100,50,20,10,5,2,1,0.8,0.5,0.2,0.1,0.01};
	
	public static Map<Double, Double> sol = new HashMap<>();
	
    public static void main( String[] args )
    {
    	double t= 5.2;
    	double g = 8.4;
    	System.out.println(t + g);
//       double paid        = 150;
//       double value       = 15;
//       double returnValue = paid - value;
//       System.out.println("the item value is : " + 13.5 + " the paid is " + paid + " the value should returned is : " + returnValue);
//       getParts(returnValue);
//       print();
//       
    }
    
    public static double getTheCloseNum(double num)
    {
    	double closeNum = 0;
    	for( int i = 0 ; i < Basic.length; i++)
    	{
    		double basNum = Basic[i];
    		if (basNum > num )
    			continue;
    		else if ( basNum < num && i <  Basic.length )
    		{
    			return Basic[i];
    		}
    	}
    	return closeNum;
    }

    public static void getParts(double num)
    {
    	if (num == 0)
    		return;
    	boolean isBasic = false;
    	int     i;
    	for( i =  0 ; i < Basic.length ; i++)
    	{
    		if ( num == Basic[i] ) {
    			isBasic = true;
    			
    	    	double close = getTheCloseNum(num);
    	    	double oldCount  = 1;
    	    	if ( sol.containsKey(close) )
    	    	{
    	      		oldCount  = sol.get(close);
    	    		oldCount++;
    	    	}
    	    	sol.put(close, oldCount);
    			return;
    		}
    	}
   
    		
    	// add the close to an map
    	double close = getTheCloseNum(num);
    	double oldCount = 1;
    	if ( sol.containsKey(close) )
    	{
      		oldCount  = sol.get(close);
    		oldCount++;
    	}
		sol.put(close, oldCount);

  
    	getParts(num - close);
    	
    }
    
    
    public static void print()
    {
    	for( int i = 0; i < Basic.length ; i++)
    	{
    		double basic = Basic[i];
    		if ( sol.containsKey(basic))
    		{
        		double count = sol.get(basic);
        		System.out.println("for (" + basic + ") : " + count);
    		}
    		else
    		{
        		System.out.println("for (" + basic + ") : 0 ");
    		}
    	}
    }
    
    
    
}
