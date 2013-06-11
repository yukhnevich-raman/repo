package com.atm.utils;

import com.atm.domain.Card;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Raman_Yukhnevich
 * Date: 3/25/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CardToJson {

    /**
     * Represent card information in JSON format
     * @param card
     * @return String json reperesentation
     */
    public String toJson(Card card) {
        JSONObject json = new JSONObject();
        JSONObject cJson = new JSONObject();
        if (card != null) {
            try {
                json.put("id", card.getId());
                json.put("name", card.getName());
                json.put("surname", card.getSurname());
                json.put("amount", card.getAmount());
                json.put("currency", card.getCurrency());
                cJson.accumulate("card", json);
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            try {
                json.put("sucess", "false");
                json.put("errors", "Card not found");
                cJson.accumulate("card", json);
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return cJson.toString();
    }
}
