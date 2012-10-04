package com.atm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atm.domain.Card;


@Repository
public class CardDAOImpl implements CardDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void addCard(Card card) {
		sessionFactory.getCurrentSession().save(card);		
	}

	public Card getCard(Integer id) {	
		return (Card)sessionFactory.openSession().load(Card.class, id);
	}

	public void removeCard(Integer id) {
		Card card = (Card)sessionFactory.openSession().load(Card.class, id);
		if(card!=null) {
			sessionFactory.getCurrentSession().delete(card);
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> getCards() {
		return sessionFactory.getCurrentSession().createQuery("from Card")
	            .list();
	}

}
