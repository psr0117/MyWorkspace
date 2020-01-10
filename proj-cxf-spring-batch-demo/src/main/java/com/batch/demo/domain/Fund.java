package com.batch.demo.domain;

public class Fund {

	private String symbol;
	private String cusip;
	private String name;

	public Fund() {
		
	}
	public Fund(String symbol, String cusip, String name) {
		super();
		this.symbol = symbol;
		this.cusip = cusip;
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fund [symbol=" + symbol + ", cusip=" + cusip + ", name=" + name + "]";
	}

}
