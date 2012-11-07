package com.atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import com.atm.domain.Card;
import com.atm.service.CardService;
import com.atm.utils.Utils;

@Component
public class AdminPageUtils {
	
	@Autowired
	private CardService cardService;
	@Autowired 
	private Utils util;
	private Card card;
	private String message;
	
	public void admin(Model model) {
		model.addAttribute("card", new Card());
    	model.addAttribute("block", util.getBlocked(cardService.getCards()));
    	model.addAttribute("currency", Currency.values());
    	model.addAttribute("blocked", Blocked.values());
    	model.addAttribute("message",message );
    	message="";
    	model.addAttribute("cards", cardService.getCards());
	}
	
	public void addCard(Card card) {
		cardService.addCard(card);
    	message ="<h2><font color='green'>Card was successfully created. Your card id is: <br/>"+card.getId()+"</font></h2>";
	}
	
	public void removeCard(Integer id) {
		cardService.removeCard(id);
    	message = "<h2><font color='green'>Card "+id+" was successfully deleted.</font></h2>";
	}
	
	public void unblockCard(Integer id) {
		card = cardService.getCard(id);
    	card.setBlocked("N");
    	cardService.update(card);
    	message = "<h2><font color='green'>Card "+id+" was successfully unblocked.</font></h2>";
	}
 
}
