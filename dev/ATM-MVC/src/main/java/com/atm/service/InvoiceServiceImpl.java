package com.atm.service;

import com.atm.dao.InvoiceDAO;
import com.atm.domain.Card;
import com.atm.domain.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    /**
     * Puts new invoice in database
     *
     * @param invoice
     */
    @Transactional
    public void addInvoice(Invoice invoice) {
        invoiceDAO.addInvoice(invoice);
    }

    /**
     * Get outcome invoices associated with specific card
     *
     * @param card
     * @return List<Invoice>
     */
    @Transactional
    public List<Invoice> getOutcome(Card card) {
        return invoiceDAO.getOutcome(card);
    }

    /**
     * Get income invoices associated with specific card
     *
     * @param card
     * @return List<Invoice>
     */
    @Transactional
    public List<Invoice> getIncome(Card card) {
        return invoiceDAO.getIncome(card);
    }
}
