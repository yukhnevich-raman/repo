package com.atm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atm.domain.Card;
import com.atm.domain.Invoice;

@Repository
public interface InvoiceDAO {
	public void addInvoice(Invoice invoice);
	public List<Invoice> getOutcome(Card card);	
	public List<Invoice> getIncome(Card card);
}
