package com.atm.dao;

import org.springframework.stereotype.Repository;
import com.atm.domain.Card;

@Repository
public interface CardDAO {

	public void addCard(Card card);

	public Card getCard(Integer id);

	public void removeCard(Integer id);

}