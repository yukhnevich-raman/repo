package com.atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.atm.domain.Card;
import com.atm.service.CardService;

@Component
public class IndexPageUtils {

	@Autowired
	private CardService cardService;
	private Card card;
	private String error;
	private Integer cardNumber = 0;
	
	public Card getCard() {
		return card;
	}

	public void index(Model model) {
		model.addAttribute("error", error);
    	model.addAttribute("cards", cardService.getCards());
	}
	
	public String check(Integer number,Integer pin) {
		error = "";
		card = cardService.getCard(number);
		if(card == null) {
			error = "<h2><font color='red'>Invalid card number! Please try again</font></h2>";
			return "redirect:/index";
		}
		Integer pincode = card.getPin();
		if(!pincode.equals(pin)) {
			card.setAttemps(card.getAttemps()-1);
			cardService.update(card);
			if(card.getAttemps()!= 0) {				
				error = "<h2><font color='red'>Invalid pin code! "+card.getAttemps() +" attempts remained </font></h2>";
				return "redirect:/index";
			} else {				
				error = "<h2><font color='red'>Invalid pin code! Your card was blocked!<br/>Insert another card</font></h2>";
				card.setBlocked("Y");
				card.setAttemps(3);
				cardService.update(card);
				return "redirect:/index";
			}
		} else {
			return "redirect:/opperations";
		}
	}
	
	public String checkPin(Integer number,Integer pin) {
		if (cardNumber == 0) {
			cardNumber = number;
		}
		if(number == cardNumber) {
			return check(number, pin);
		} else {
			card = cardService.getCard(cardNumber);
			card.setAttemps(3);
			cardService.update(card);
			return check(number, pin);
		}		
	}
}
