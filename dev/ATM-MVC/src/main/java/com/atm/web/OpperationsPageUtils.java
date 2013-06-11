package com.atm.web;

import com.atm.domain.Card;
import com.atm.domain.Invoice;
import com.atm.service.CardService;
import com.atm.service.InvoiceService;
import com.atm.utils.CurrencyConverter;
import com.atm.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class OpperationsPageUtils {

    @Autowired
    private Utils utils;
    @Autowired
    private CurrencyConverter converter;
    @Autowired
    private CardService cardService;
    @Autowired
    private InvoiceService invoiceService;
    private Card currentCard;
    private List<Card> transferCards;
    private String result;

    /**
     *
     * @param request
     * @return  if user is authorized redirect to operations page else  redirect to index
     */
    public String opperations(HttpServletRequest request) {
        try {
            this.currentCard = (Card) request.getSession().getAttribute("Card");
            this.transferCards = utils.getTransfer(cardService.getCards(), currentCard.getId());
        } catch (Exception e) {
            return "redirect:/";
        }
        return "redirect:bank/operations";
    }

    /**
     * Transfer money from current to another card
     * @param destCardId
     * @param amount
     * @param r
     * @return result in JSON format
     */
    @Transactional
    public String transferMoney(Integer destCardId, double amount, HttpServletRequest r) {
        Card toCard = cardService.getCard(destCardId);
        double currentAmount = currentCard.getAmount();
        JSONObject json = new JSONObject();
        if (currentAmount < amount) {
            try {
                json.put("sucess", false);
                json.put("result", "Недостаточно средств.");
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

        } else {
            currentCard.setAmount(currentAmount - amount);
            double newAmount = converter.convert(currentCard.getCurrency(), toCard.getCurrency(), amount);
            toCard.setAmount(toCard.getAmount() + newAmount);
            Invoice invoice = currentCard.createInvoice();
            invoice.setToCard(destCardId);
            invoice.setAmount(newAmount);
            String date = new SimpleDateFormat("dd.MM.yyyy-hh.mm-a").format(GregorianCalendar.getInstance().getTime());
            invoice.setDate(date);
            invoice.setCurrency(toCard.getCurrency());
            invoiceService.addInvoice(invoice);
            try {
                json.put("sucess", true);
                json.put("result", "Успешно.");
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        cardService.update(currentCard);
        r.getSession().setAttribute("Card", currentCard);
        cardService.update(toCard);
        return json.toString();
    }

    /**
     * Pay
     * @param amount
     * @param to
     * @param r
     * @return
     */
    public String pay(Double amount, Integer to, HttpServletRequest r) {
        JSONObject json = new JSONObject();
        double currentAmount = currentCard.getAmount();
        if (currentAmount < amount) {
            try {
                json.put("sucess", false);
                json.put("result", "No enough money.Choose anothe opperation.");
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            currentCard.setAmount(currentAmount - amount);
            Invoice invoice = currentCard.createInvoice();
            invoice.setToCard(to);
            invoice.setAmount(amount);
            String date = new SimpleDateFormat("dd.MM.yyyy-hh.mm-a").format(GregorianCalendar.getInstance().getTime());
            invoice.setDate(date);
            invoice.setCurrency(currentCard.getCurrency());
            invoiceService.addInvoice(invoice);
            try {
                json.put("success", true);
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        cardService.update(currentCard);
        r.getSession().setAttribute("Card", currentCard);
        return json.toString();
    }

    /**
     * Exchange money calculator
     * @param from
     * @param to
     * @param amount
     * @return
     */
    public String exchange(String from, String to, double amount) {
        JSONObject json = new JSONObject();
        try {
            json.put("success", true);
            json.put("result", converter.convert(from, to, amount).toString());
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return json.toString();
    }

    /**
     * Get billing history
     * @param card
     * @param limit
     * @param start
     * @return
     */

    public String getHistory(Card card, Integer limit, Integer start) {
        this.currentCard = card;
        JSONObject json = new JSONObject();
        List<Invoice> history = invoiceService.getIncome(currentCard);
        history.addAll(invoiceService.getOutcome(currentCard));
        try {
            json.put("total", history.size());
            for (int i = start; i <= start + limit && i < history.size(); i++) {
                json.accumulate("history", history.get(i).toJson());
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     *
     * @return all allowed cards to transfer money
     */
    public String getTransferCards() {
        JSONObject j = new JSONObject();
        try {
            for (Card card : transferCards) {
                JSONObject json = new JSONObject();
                json.put("card", card.getId());
                j.accumulate("cards", json);
            }
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return j.toString();
    }

    /**
     *
     * @return  all currencies values
     */
    public String getCurrencies() {
        JSONObject j = new JSONObject();
        Currency array[] = Currency.values();

        for (int i = 0; i < array.length; i++) {
            try {
                JSONObject json = new JSONObject();
                json.put("currency", array[i].name());
                j.accumulate("currencies", json);
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return j.toString();
    }
}
