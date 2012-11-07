package com.atm.web;

public enum Currency {	
	USD (8000,0.7,1),
	BYR (1,0.000083,0.000125),
	EUR (12000,1,1.43);
	
	private final double byr;
	private final double eur;	
	private final double usd;
	
	public double getByr() {
		return byr;
	}

	public double getEur() {
		return eur;
	}

	public double getUsd() {
		return usd;
	}

	Currency(double byr,double eur,double usd) {
		this.byr = byr;
		this.eur = eur;
		this.usd = usd;
	}
}
