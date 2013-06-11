package com.atm.dao;

import com.atm.domain.Card;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDAO {

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
     * Get all existing cards from store
     *
     * @return List<Card>
     */
    public List<Card> getCards();

    /**
     * Remove existing card from store
     *
     * @param id - existing card id
     */
    public void removeCard(Integer id);

    /**
     * Update existing card from store
     *
     * @param card - existing card id
     */
    public void update(Card card);
}
