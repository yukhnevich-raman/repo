package com.atm.web;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.atm.domain.Card;
import com.atm.domain.Invoice;
import com.atm.service.CardService;
import com.atm.service.InvoiceService;
import com.atm.utils.CurrencyConverter;
import com.atm.utils.Utils;

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
	private double currentAmount;
	private String error;
	private String result;
	
	public void reset() {
		error = "";
		result = "";
	}
	
	public void opperations(Model model, Card card) {
		this.currentCard = card;
		this.currentAmount = currentCard.getAmount();
		model.addAttribute("card",currentCard);
		model.addAttribute("result",result);
		model.addAttribute("error",error);
		List<Card> transferCards = utils.getTransfer(cardService.getCards(), currentCard.getId());
		model.addAttribute("transfer",transferCards);
		model.addAttribute("outcome", invoiceService.getOutcome(currentCard));
		model.addAttribute("income", invoiceService.getIncome(currentCard));
		model.addAttribute("currency", Currency.values());
	}
	
	@Transactional
	public void transferMoney(Integer destCardId, double amount) {
		Card toCard = cardService.getCard(destCardId);
		if (currentAmount< amount) {
			error = "No enough money. <br/>Choose anothe opperation.";
		} else {
			currentCard.setAmount(currentAmount - amount);
			double newAmount = converter.convert(currentCard.getCurrency(), toCard.getCurrency(), amount);
			toCard.setAmount(toCard.getAmount()+newAmount);
			Invoice invoice = currentCard.createInvoice();
			invoice.setToCard(destCardId);
			invoice.setAmount(newAmount);
			String date = new SimpleDateFormat("dd.MM.yyyy-hh.mm-a").format(GregorianCalendar.getInstance().getTime());
			invoice.setDate(date);
			invoice.setCurrency(toCard.getCurrency());
			invoiceService.addInvoice(invoice);
			error = "Success. <br/>Choose another opperation.";
		}
		cardService.update(currentCard);
		cardService.update(toCard);
	}
	
	public void exchange(String from,String to, double amount) {
		result = converter.convert(from, to, amount).toString();
	}
}
