package com.training.exilant.day2;

public class Stock {
	private String stockName; 
	private double stockPrice;
	
	public Stock(String stockName, double stockPrice) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public String toString() {
		return "Stock [stockName=" + stockName + ", stockPrice=" + stockPrice + "]";
	} 
	
	
	
}
