package com.hilfreich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EngNumTextToNum 
{
	
	public static void main(String[] args)
	{       
	        
		List<String> strList = List.of(
	    		"eight hundred eighty-eight thousand eight hundred and eighty-eight",
	       		"five hundred thousand three hundred",
	       		"two hundred three thousand",
	       		"two hundred thousand three",
	       		"six hundred sixty-six thousand six hundred sixty-six",
	       		"ninety-nine thousand nine hundred and ninety-nine",
	       		"seven hundred thirty-six",
	       		"eighty-three"
	       		);
		
		for ( String str : strList)
		{
			int value = parseInt(str);
			System.out.println(str + " ->" + value);
		}
	        
	}
	

	
	public static int parseInt(String numStr) {
	      numStr = numStr.replaceAll(" and ", " ");
	      numStr = numStr.replaceAll("-", " ");
	      int          total    = 0;
	      List<String> numArray = new ArrayList<>(Arrays.asList(numStr.split(" ")));      
 
	      for (int i = 0 ; i < numArray.size() ; i++)
	    	  
	      {
	        String str = numArray.get(i);
	        int    num = getNumAsInt(str);
	        if(str.equals("million"))
	        {
	          total = total * 100_00_00;
	          continue;
	        }
	        if(str.equals("thousand"))
	        {
	          int lastNum = (total%1000);
	          total = total - lastNum + (lastNum * 1000 );
	          continue;
	        }
	        if(str.equals("hundred"))  
	        {
	          int lastNum = (total%100);
	          total = total - lastNum + (lastNum * 100 );
	          continue;
	        }		        
	        if ( num > -1) 
	        {
	          total  = total + num;
	          if(str.endsWith("ty")) 
	          {
	            total  = total - num;
	            total = total + (num * 10);
	          }
	          if(str.endsWith("teen"))
	          {
	            total = total +  10;
	          }
	        }
	      }
	        return total;
	    }
	  
		  
	    public static int getNumAsInt(String str)
	    {
	      if (str.equals("zero"))       return 0;
	      if (str.equals("one"))        return 1;
	      if (str.equals("ten"))        return 10;
	      if (str.equals("eleven"))     return 11;
	      if (str.equals("twelve"))     return 12;
	      if (str.startsWith("tw"))     return 2;
	      if (str.startsWith("th"))     return 3;
	      if (str.startsWith("fo"))     return 4;
	      if (str.startsWith("fi"))     return 5;
	      if (str.startsWith("six"))    return 6;
	      if (str.startsWith("seven"))  return 7;
	      if (str.startsWith("eight"))  return 8;
	      if (str.startsWith("nine"))   return 9;
	      return -1;	      
	    }	
	
}
