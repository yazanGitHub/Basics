package com.hilfreich;

import java.math.BigInteger;

public class NumberOfTrailingZerosOfNFactor {
	/*
	 * Consider the number 25! (read as "25 factorial"). The factorial of 25 is calculated as follows:

25! = 25 * 24 * 23 * ... * 3 * 2 * 1

Now, let's look at the prime factorization of the numbers involved:

25 = 5^2
24 = 2^3 * 3
23 = 23
...
3 = 3
2 = 2
1 = 1
When you multiply all these numbers together to calculate 25!, you're essentially calculating:

25! = (5^2) * (2^3 * 3) * 23 * ... * 3 * 2 * 1

Now, let's focus on the prime factors 2 and 5. The number of trailing zeros in the factorial is determined by how many times the number can be divided by 10 (which is 2 * 5). Since we have more factors of 2 than factors of 5, we just need to count the factors of 5.

In the list of numbers we're multiplying, there is one 25, one 20 (which has two factors of 5), one 15 (which has one factor of 5), and so on. So, the total number of factors of 5 is:

1 (from 25) + 2 (from 20) + 1 (from 15) + ... + 1 (from 5) = 6

Therefore, 25! has 6 trailing zeros.
	 */
	public static void main(String[] args)
	{
		long fact = getFactor(20);
		int zero = zeros(20);
		
		System.out.println("fact is : " + fact);
		System.out.println("zero is : " + zero);
	}
	
	  public static int zeros(int n) {
		    int res = 0;
		    for (int i = 5; i <= n; i *= 5) {
		      res += n / i;
		    }
		    return res;
		  }
	  
	  public static long getFactor(long num)
	  {
		  if (num == 0 || num == 1)
			  return 1;
		  return num * getFactor(num-1);
	  }
}
