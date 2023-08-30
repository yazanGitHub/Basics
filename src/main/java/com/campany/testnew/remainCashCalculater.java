package com.campany.testnew;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class remainCashCalculater
{
	public static void main(String [] args)
	{
		
		List<BigDecimal> BasicBill = List.of(
				new BigDecimal("500.00"),
				new BigDecimal("200.00"),
				new BigDecimal("100.00"),
				new BigDecimal("50.00"),
				new BigDecimal("20.00"),
				new BigDecimal("10.00"),
				new BigDecimal("5.00"),
				new BigDecimal("2.00"),
				new BigDecimal("1.00"),
				new BigDecimal("0.50"),
				new BigDecimal("0.20"),
				new BigDecimal("0.10"),
				new BigDecimal("0.01")
				);
		
		Map<BigDecimal, Integer> parts = new HashMap<BigDecimal, Integer>();
		BigDecimal paid      = new BigDecimal("500.00");
		BigDecimal itemValue = new BigDecimal("11.21");
		BigDecimal remain    = paid.subtract(itemValue);
		System.out.println("the paid is : " + paid + "the itemValue is : " + itemValue + "the remain is : " + remain);
		if (remain.intValue() < 0 )
		{
			System.out.println("Error please check the inputs values");
			return;
		}
		int index = -1;

		while(!(remain.signum() == 0))
		{
			index++;
			BigDecimal base = BasicBill.get(index);
			if ( base.compareTo(remain) > 0)
				continue;
			else
			{	
				remain = remain.subtract(base);
				addPart(parts, base);
				index  = -1;
			}
		}
		print(BasicBill,parts);
	}
	
	public static void addPart(Map<BigDecimal, Integer> parts, BigDecimal part)
	{
		if (parts.containsKey(part))
		{
			int oldVal = parts.get(part);
			parts.put(part, (oldVal + 1));
		}
		else
			parts.put(part, 1);
	}
	
	public static void print(List<BigDecimal> BasicBill ,Map<BigDecimal, Integer> parts)
	{
		for (BigDecimal temp : BasicBill)
		{
			if(parts.containsKey(temp))
			{
				System.out.println("for " + temp + " should return : " + parts.get(temp));
			}
			else
			{
				System.out.println("for " + temp + " should return : " + 0);
			}
		}
	}
	
}
