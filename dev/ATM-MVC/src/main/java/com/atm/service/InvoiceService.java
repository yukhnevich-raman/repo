package com.atm.service;

import com.atm.domain.Card;
import com.atm.domain.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    /**
     * Puts new invoice in store
     * @param invoice
     */
    public void addInvoice(Invoice invoice);

    /**
     *
     * Get outcome invoices associated with specific card
     * @param card
     * @return  List<Invoice>
     */
    public List<Invoice> getOutcome(Card card);

    /**
     * Get income invoices associated with specific card
     * @param card
     * @return  List<Invoice>
     */
    public List<Invoice> getIncome(Card card);
}
