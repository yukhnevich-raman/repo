package com.atm.service;

import com.atm.dao.CardDAO;
import com.atm.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDAO cardDAO;


    public CardDAO getCardDAO() {
        return cardDAO;
    }

    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    /**
     * Puts a new card to database
     *
     * @param card - the card instance to put in database
     */
    @Transactional
    public void addCard(Card card) {
        cardDAO.addCard(card);

    }

    /**
     * Get existing card from database
     *
     * @param id - existing card id
     * @return Card
     */
    @Transactional
    public Card getCard(Integer id) {
        return cardDAO.getCard(id);
    }

    /**
     * Remove existing card from database
     *
     * @param id - existing card id
     */
    @Transactional
    public void removeCard(Integer id) {
        cardDAO.removeCard(id);
    }

    /**
     * Get all existing cards from database
     *
     * @return List<Card>
     */
    @Transactional
    public List<Card> getCards() {
        return cardDAO.getCards();
    }

    /**
     * Update existing card from database
     *
     * @param card - existing card id
     */
    @Transactional
    public void update(Card card) {
        cardDAO.update(card);
    }
}
