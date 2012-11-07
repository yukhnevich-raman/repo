package com.atm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice { 
	
	private Integer id;	
	private double amount;
	private Integer fromCard;
	private Integer toCard;
	private String currency;
	private String date;
	
	
	@Id
	@GeneratedValue
	@Column(name ="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name ="AMOUNT")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Column(name ="FROM_CARD")
	public Integer getFromCard() {
		return fromCard;
	}
	public void setFromCard(Integer fromCard) {
		this.fromCard = fromCard;
	}
	
	@Column(name ="TO_CARD")
	public Integer getToCard() {
		return toCard;
	}
	public void setToCard(Integer toCard) {
		this.toCard = toCard;
	}
	
	@Column(name ="DATE")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Column(name ="CURRENCY")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
