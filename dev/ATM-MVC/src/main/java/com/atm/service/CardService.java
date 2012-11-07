package com.atm.service;

import java.util.List;

import com.atm.domain.Card;

public interface CardService {
	public void addCard(Card card);
	public Card getCard(Integer id);
	public void removeCard(Integer id);
	public List<Card> getCards();
	public void update(Card card);
}
