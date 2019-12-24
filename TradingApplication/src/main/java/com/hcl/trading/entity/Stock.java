package com.hcl.trading.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	
	@Id
	private int stockid;
	private String stockname;
	private int quantity;
	private double price;
	private int brokerage;
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBrokerage() {
		return brokerage;
	}
	public void setBrokerage(int brokerage) {
		this.brokerage = brokerage;
	}
	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", stockname=" + stockname + ", quantity=" + quantity + ", price=" + price
				+ ", brokerage=" + brokerage + "]";
	}
	public Stock(int stockid, String stockname, int quantity, double price, int brokerage) {
		super();
		this.stockid = stockid;
		this.stockname = stockname;
		this.quantity = quantity;
		this.price = price;
		this.brokerage = brokerage;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
