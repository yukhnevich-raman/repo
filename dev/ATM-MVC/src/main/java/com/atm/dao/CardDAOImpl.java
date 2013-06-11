package com.atm.dao;

import com.atm.domain.Card;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CardDAOImpl implements CardDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Puts a new card to database
     *
     * @param card - the card instance to put in database
     */
    public void addCard(Card card) {
        sessionFactory.getCurrentSession().save(card);
    }

    /**
     * Get existing card from database
     *
     * @param id - existing card id
     * @return Card
     */
    public Card getCard(Integer id) {
        return (Card) sessionFactory.openSession().load(Card.class, id);
    }

    /**
     * Remove existing card from database
     *
     * @param id - existing card id
     */
    public void removeCard(Integer id) {
        Card card = (Card) sessionFactory.openSession().load(Card.class, id);
        if (card != null) {
            sessionFactory.getCurrentSession().delete(card);
        }
    }

    /**
     * Get all existing cards from database
     *
     * @return List<Card>
     */
    @SuppressWarnings("unchecked")
    public List<Card> getCards() {
        return sessionFactory.getCurrentSession().createQuery("from Card")
                .list();
    }

    /**
     * Update existing card from database
     *
     * @param card - existing card id
     */
    public void update(Card card) {
        sessionFactory.getCurrentSession().update(card);
    }

}
