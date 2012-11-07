package com.atm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card { 
	
	private Integer id;	
	private double amount;
	private Integer pin;
	private String name;
	private String surname;
	private String currency;
	private String blocked;
	private Integer attemps;
	
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
	
	@Column(name ="PIN")
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	
	@Column(name ="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name ="SURNAME")
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name ="CURRENCY")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Column(name ="BLOCKED")
	public String getBlocked() {
		return blocked;
	}
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
	
	@Override 
	public String toString() {
		return "/nCard id="+id+
				"/nCard pin code ="+pin+
				"/nCard amount="+amount+
				"/nCardholder name="+name+
				"/nCardholder surname="+surname+
				"/nCard currency="+currency+
				"/nCard blocked="+blocked;
	}
	
	@Column(name ="ATTEMPS")
	public Integer getAttemps() {
		return attemps;
	}
	public void setAttemps(Integer attemps) {
		this.attemps = attemps;
	}
	 public Invoice createInvoice() {
		 Invoice invoice = new Invoice();
		 invoice.setFromCard(this.id);
		 return invoice;
	 }
}
