package com.atm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.atm.domain.Card;

@Repository
public interface CardDAO {

	public void addCard(Card card);
	public Card getCard(Integer id);	
	public List<Card> getCards();
	public void removeCard(Integer id);
	public void update(Card card);
}
