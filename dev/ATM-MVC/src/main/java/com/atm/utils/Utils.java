package com.atm.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.atm.domain.Card;

@Component
public class Utils {
	public List<Card> getBlocked(List<Card> cards) {
		List<Card> blocked = new ArrayList<Card>();
		for(Card card:cards) {
			if(card.getBlocked().equalsIgnoreCase("y")) {
				blocked.add(card);
			}
		}
		return blocked;
	}
	
	public List<Card> getTransfer(List<Card> cards, Integer id) {
		List<Card> transfer = new ArrayList<Card>();
		for(Card card:cards) {
			if(!card.getId().equals(id)) {
				transfer.add(card);
			}
		}
		return transfer;
	}
}
