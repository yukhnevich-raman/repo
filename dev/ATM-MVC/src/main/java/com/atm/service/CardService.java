package com.atm.service;

import com.atm.domain.Card;

import java.util.List;

public interface CardService {

    /**
     * Puts a new card to store
     *
     * @param card - the card instance to put in store
     */
    public void addCard(Card card);

    /**
     * Get existing card from store
     *
     * @param id - existing card id
     * @return Card
     */
    public Card getCard(Integer id);

    /**
     * Remove existing card from store
     *
     * @param id - existing card id
     */
    public void removeCard(Integer id);

    /**
     * Get all existing cards from store
     *
     * @return List<Card>
     */
    public List<Card> getCards();

    /**
     * Update existing card from store
     *
     * @param card - existing card id
     */
    public void update(Card card);
}
