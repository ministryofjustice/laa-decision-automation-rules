package com.laa.rule.factcheckers;

import java.math.BigDecimal;

public class Thresholds {

	
	private BigDecimal capitalLowerLimit;
	
	private BigDecimal capitalUpperLimit;
	
	private BigDecimal grossIncomeUpperLimit;

	private BigDecimal disposableIncomeUpperLimit;
	
	private BigDecimal disposableIncomeUpperLimitDV;
	
	private BigDecimal disposableBand0 = BigDecimal.ZERO;
	
	private BigDecimal disposableBand1 = new BigDecimal("0.35");
	
	private BigDecimal disposableBand2 = new BigDecimal("0.45");
	
	private BigDecimal disposableBand3 = new BigDecimal("0.50");
	
	private BigDecimal disposableBand1Limit = new BigDecimal("310.00");
	
	private BigDecimal disposableBand2Limit = new BigDecimal("465.00");
	
	private BigDecimal disposableBand3Limit = new BigDecimal("616.00");
	
	private BigDecimal mortgageMonthlyCap;

	public BigDecimal getCapitalLowerLimit() {
		return capitalLowerLimit;
	}

	public void setCapitalLowerLimit(BigDecimal capitalLowerLimit) {
		this.capitalLowerLimit = capitalLowerLimit;
	}

	public BigDecimal getCapitalUpperLimit() {
		return capitalUpperLimit;
	}

	public void setCapitalUpperLimit(BigDecimal capitalUpperLimit) {
		this.capitalUpperLimit = capitalUpperLimit;
	}

	public BigDecimal getGrossIncomeUpperLimit() {
		return grossIncomeUpperLimit;
	}

	public void setGrossIncomeUpperLimit(BigDecimal grossIncomeUpperLimit) {
		this.grossIncomeUpperLimit = grossIncomeUpperLimit;
	}

	public BigDecimal getDisposableIncomeUpperLimit() {
		return disposableIncomeUpperLimit;
	}

	public void setDisposableIncomeUpperLimit(BigDecimal disposableIncomeUpperLimit) {
		this.disposableIncomeUpperLimit = disposableIncomeUpperLimit;
	}

	public BigDecimal getDisposableBand0() {
		return disposableBand0;
	}

	public void setDisposableBand0(BigDecimal disposableBand0) {
		this.disposableBand0 = disposableBand0;
	}

	public BigDecimal getDisposableBand1() {
		return disposableBand1;
	}

	public void setDisposableBand1(BigDecimal disposableBand1) {
		this.disposableBand1 = disposableBand1;
	}

	public BigDecimal getDisposableBand2() {
		return disposableBand2;
	}

	public void setDisposableBand2(BigDecimal disposableBand2) {
		this.disposableBand2 = disposableBand2;
	}

	public BigDecimal getDisposableBand3() {
		return disposableBand3;
	}

	public void setDisposableBand3(BigDecimal disposableBand3) {
		this.disposableBand3 = disposableBand3;
	}

	public BigDecimal getDisposableBand1Limit() {
		return disposableBand1Limit;
	}

	public void setDisposableBand1Limit(BigDecimal disposableBand1Limit) {
		this.disposableBand1Limit = disposableBand1Limit;
	}

	public BigDecimal getDisposableBand2Limit() {
		return disposableBand2Limit;
	}

	public void setDisposableBand2Limit(BigDecimal disposableBand2Limit) {
		this.disposableBand2Limit = disposableBand2Limit;
	}

	public BigDecimal getDisposableBand3Limit() {
		return disposableBand3Limit;
	}

	public void setDisposableBand3Limit(BigDecimal disposableBand3Limit) {
		this.disposableBand3Limit = disposableBand3Limit;
	}

	public BigDecimal getMortgageMonthlyCap() {
		return mortgageMonthlyCap;
	}

	public void setMortgageMonthlyCap(BigDecimal mortgageMonthlyCap) {
		this.mortgageMonthlyCap = mortgageMonthlyCap;
	}
	
	public BigDecimal getDisposableIncomeUpperLimitDV() {
		return disposableIncomeUpperLimitDV;
	}

	public void setDisposableIncomeUpperLimitDV(BigDecimal disposableIncomeUpperLimitDV) {
		this.disposableIncomeUpperLimitDV = disposableIncomeUpperLimitDV;
	}
	
	
}
