package com.nivi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class Stock {

	@Id
	@Column(name="stockid")
	private int stockid;
	@Column(name="name")
	private String name;
	@Column(name="qty")
	private int qty;
	@Column(name="price")
	private int price;
	@Column(name="brokerage")
	private int brokerage;
	@Column(name="userid")
	private int userid;
	
	
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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
		return "Stock [stockid=" + stockid + ", name=" + name + ", qty=" + qty + ", price=" + price + ", brokerage="
				+ brokerage + ", userid=" + userid + "]";
	}
	public Stock(int stockid, String name, int qty, int price, int brokerage, int userid) {
		super();
		this.stockid = stockid;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.brokerage = brokerage;
		this.userid = userid;
	}
	
	
	
}
