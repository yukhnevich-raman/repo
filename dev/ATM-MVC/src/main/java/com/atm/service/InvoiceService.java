package com.atm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atm.domain.Card;
import com.atm.domain.Invoice;

@Service
public interface InvoiceService {
	public void addInvoice(Invoice invoice);
	public List<Invoice> getOutcome(Card card);
	public List<Invoice> getIncome(Card card);
}
