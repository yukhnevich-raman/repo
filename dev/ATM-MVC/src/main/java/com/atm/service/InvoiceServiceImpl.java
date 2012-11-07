package com.atm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atm.dao.InvoiceDAO;
import com.atm.domain.Card;
import com.atm.domain.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceDAO invoiceDAO;

	@Transactional
	public void addInvoice(Invoice invoice) {
		invoiceDAO.addInvoice(invoice);		
	}

	@Transactional
	public List<Invoice> getOutcome(Card card) {
		return invoiceDAO.getOutcome(card);
	}

	@Transactional
	public List<Invoice> getIncome(Card card) {
		return invoiceDAO.getIncome(card);
	}
}
