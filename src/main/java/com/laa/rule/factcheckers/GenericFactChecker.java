package com.laa.rule.factcheckers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class GenericFactChecker {
	
	private String fact;
	
	

	public GenericFactChecker(String fact) {
		super();
		this.fact = fact;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fact == null) ? 0 : fact.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericFactChecker other = (GenericFactChecker) obj;
		if (fact == null) {
			if (other.fact != null)
				return false;
		} else if (!fact.equals(other.fact))
			return false;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		BigDecimal value = new BigDecimal("100000.00");
		System.out.println(value.compareTo(new BigDecimal("3000.00")) );
	}

}
