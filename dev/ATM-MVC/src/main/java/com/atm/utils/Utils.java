package com.atm.utils;

import com.atm.domain.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {

    /**
     * Get list of blocked cards
     * @param cards - all cards
     * @return List<Card>
     */
    public List<Card> getBlocked(List<Card> cards) {
        List<Card> blocked = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getBlocked().equalsIgnoreCase("y")) {
                blocked.add(card);
            }
        }
        return blocked;
    }

    /**
     * Get list of possible transfer cards (except current)
     * @param cards - all cards
     * @param id - current card id
     * @return  List<Card>
     */
    public List<Card> getTransfer(List<Card> cards, Integer id) {
        List<Card> transfer = new ArrayList<Card>();
        for (Card card : cards) {
            if (!card.getId().equals(id)) {
                transfer.add(card);
            }
        }
        return transfer;
    }
}
