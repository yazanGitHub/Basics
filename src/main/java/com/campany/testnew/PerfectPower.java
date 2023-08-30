package com.campany.testnew;

public class PerfectPower {
	public static void main(String [] args )
	{
		int number = 124;
		int [] sol = isPerfectPower(number);
		if ( sol != null )
			System.out.println(sol[0] + "  " +  sol[1]);
		else
			System.out.println("there is no perfect power for number " + number);
	}
	
	
	 public static int[] isPerfectPower(int n) {
	        for (int i = 2; ; i++) 
	        {
	            int root = (int) Math.round(Math.pow(n, 1.0 / i));
	            if (root < 2) return null;
	            if (Math.pow(root, i) == n) 
	            	return new int[]{root, i};
	        }
	    }
}
