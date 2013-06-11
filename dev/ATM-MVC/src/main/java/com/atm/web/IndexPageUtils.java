package com.atm.web;

import com.atm.domain.Card;
import com.atm.service.CardService;
import com.atm.utils.HashPin;
import org.hibernate.HibernateException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class IndexPageUtils {

    @Autowired
    private CardService cardService;
    private Card card;
    private String error;
    private Integer cardNumber = 0;
    private JSONObject json;

    private JSONObject check(Integer number, Integer pin, HttpServletRequest request) {
        error = "";
        json = new JSONObject();
        try {
            card = cardService.getCard(number);
        } catch (HibernateException e) {
            error = "Неверный номер карты!";
            try {
                json.put("success", "false");
                json.put("errors", error);
            } catch (JSONException ex) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return json;
        }
        Integer pincode = card.getPin();
        if (!pincode.equals(pin)) {
            card.setAttemps(card.getAttemps() - 1);
            cardService.update(card);
            if (card.getAttemps() != 0) {
                try {
                    json.put("success", "false");
                    json.put("errors", "В доступе отказано!");
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                return json;
            } else {
                error = "Карточка заблокирована!";
                card.setBlocked("Y");
                card.setAttemps(3);
                cardService.update(card);
                try {
                    json.put("success", "false");
                    json.put("errors", error);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return json;
            }
        } else {

            try {
                json.put("success", "true");
                HttpSession session = request.getSession();
                session.setAttribute("Card", card);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return json;
        }
    }

    /**
     * Checking pin code
     * @param number  - card number
     * @param pin  - pin code
     * @param request
     * @return  - response in JSON format
     */
    public JSONObject checkPin(Integer number, Integer pin, HttpServletRequest request) {
        pin = HashPin.hash(pin,number);
        System.out.println(pin);
        if (cardNumber == 0) {
            cardNumber = number;
        }
        if (number == cardNumber) {
            return check(number, pin, request);
        } else {
            card = cardService.getCard(cardNumber);
            card.setAttemps(3);
            cardService.update(card);
            return check(number, pin, request);
        }
    }
}
