package com.atm.service;

import com.atm.domain.Card;

public interface CardService {
	public void addCard(Card card);
	public Card getCard(Integer id);
	public void removeCard(Integer id);

}
