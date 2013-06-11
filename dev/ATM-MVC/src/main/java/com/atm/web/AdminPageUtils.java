package com.atm.web;

import com.atm.domain.Card;
import com.atm.service.CardService;
import com.atm.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminPageUtils {

    @Autowired
    private CardService cardService;
    @Autowired
    private Utils util;
    private Card card;

    /**
     * Get list of all cards in JSON array
     * @return String JSON representation
     */
    public String getCards() {
        JSONObject j = new JSONObject();
        try {
            for (Card card : cardService.getCards()) {
                JSONObject json = new JSONObject();
                json.put("card", card.getId());
                j.accumulate("cards", json);
            }
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return j.toString();
    }

    /**
     * Get list of blocked cards in JSON array
     * @return String JSON representation
     */
    public String getBlockedCards() {
        JSONObject j = new JSONObject();
        try {
            for (Card card : util.getBlocked(cardService.getCards())) {
                JSONObject json = new JSONObject();
                json.put("card", card.getId());
                j.accumulate("cards", json);
            }
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return j.toString();
    }

    /**
     * Get possible blocked values in JSON array (Y/N may be customized)
     * @see Blocked
     * @return String JSON representation
     */
    public String getBlockedValues() {
        JSONObject j = new JSONObject();
        try {
            for (Blocked blocked : Blocked.values()) {
                JSONObject json = new JSONObject();
                json.put("state", blocked.name());
                j.accumulate("blocked", json);
            }
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return j.toString();
    }

    /**
     * Put new card in datbase
     * @see CardController
     * @param card
     * @return operation result in JSON
     */
    public String addCard(Card card) {
        JSONObject json = new JSONObject();
        try {
            json.put("success", true);
            json.put("result", "Card was successfully created. Your card id is: " + card.getId());
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return json.toString();
    }

    /**
     * Remove card from datbase
     * @see CardController
     * @param id
     * @return operation result in JSON
     */
    public String removeCard(Integer id) {
        JSONObject json = new JSONObject();
        cardService.removeCard(id);
        try {
            json.put("success", true);
            json.put("result", "Card " + id + " was successfully deleted.");
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return json.toString();
    }

    /**
     * Unlock locked card
     * @see CardController
     * @param id
     * @return operation result in JSON
     */
    public String unblockCard(Integer id) {
        JSONObject json = new JSONObject();
        card = cardService.getCard(id);
        card.setBlocked("N");
        cardService.update(card);
        try {
            json.put("success", true);
            json.put("result", "Card " + id + " was successfully unblocked");
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return json.toString();
    }

}
