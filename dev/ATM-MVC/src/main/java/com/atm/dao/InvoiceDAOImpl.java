package com.atm.dao;

import com.atm.domain.Card;
import com.atm.domain.Invoice;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Puts new invoice in database
     *
     * @param invoice
     */
    public void addInvoice(Invoice invoice) {
        sessionFactory.getCurrentSession().save(invoice);
    }

    /**
     * Get outcome invoices associated with specific card
     *
     * @param card
     * @return List<Invoice>
     */
    @SuppressWarnings("unchecked")
    public List<Invoice> getOutcome(Card card) {
        Criteria getInvoiceCriteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
        getInvoiceCriteria.add(Restrictions.eq("fromCard", card.getId()));
        return getInvoiceCriteria.list();
    }

    /**
     * Get income invoices associated with specific card
     *
     * @param card
     * @return List<Invoice>
     */
    @SuppressWarnings("unchecked")
    public List<Invoice> getIncome(Card card) {
        Criteria getInvoiceCriteria = sessionFactory.getCurrentSession().createCriteria(Invoice.class);
        getInvoiceCriteria.add(Restrictions.eq("toCard", card.getId()));
        return getInvoiceCriteria.list();
    }
}
