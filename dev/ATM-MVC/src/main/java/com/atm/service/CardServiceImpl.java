package com.atm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atm.dao.CardDAO;
import com.atm.domain.Card;


@Service
public class CardServiceImpl implements CardService{

	@Autowired
	private CardDAO cardDAO;
	
	public CardDAO getCardDAO() {
		return cardDAO;
	}

	public void setCardDAO(CardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}

	@Transactional
	public void addCard(Card card) {
		cardDAO.addCard(card);
		
	}
	
	@Transactional
	public Card getCard(Integer id) {
		return cardDAO.getCard(id);
	}

	@Transactional
	public void removeCard(Integer id) {
		cardDAO.removeCard(id);
	}

	@Transactional
	public List<Card> getCards() {
		return cardDAO.getCards();
	}

	@Transactional
	public void update(Card card) {
		cardDAO.update(card);
	}
}
