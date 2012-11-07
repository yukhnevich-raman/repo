package com.atm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.atm.domain.Card;
import com.atm.domain.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addInvoice(Invoice invoice) {
		sessionFactory.getCurrentSession().save(invoice);		
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> getOutcome(Card card) {
		Criteria getInvoiceCriteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
		getInvoiceCriteria.add(Restrictions.eq("fromCard",card.getId()));
		return getInvoiceCriteria.list();
	}

	
	@SuppressWarnings("unchecked")
	public List<Invoice> getIncome(Card card) {
		Criteria getInvoiceCriteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
		getInvoiceCriteria.add(Restrictions.eq("toCard",card.getId()));
		return getInvoiceCriteria.list();
	}
}
