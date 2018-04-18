package com.laa.rule.factcheckers;

import java.math.BigDecimal;

public class BigDecimalUtils {
	
	
	public static boolean isBetween(BigDecimal number, BigDecimal lower, BigDecimal upper){
		  return number.compareTo(lower) >= 0 && number.compareTo(upper) <= 0;
	}
	
	public static boolean equals(BigDecimal number1, BigDecimal number2){
		  return (number1 == null || number2== null)? false :number1.compareTo(number2) == 0;
	}

}
