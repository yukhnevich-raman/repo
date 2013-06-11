package com.atm.web;

import com.atm.domain.Card;
import com.atm.service.CardService;
import com.atm.utils.CardToJson;
import com.atm.utils.HashPin;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private AdminPageUtils admin;
    @Autowired
    private IndexPageUtils index;
    @Autowired
    private OpperationsPageUtils opp;
    @Autowired
    private CardToJson cardToJSON;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST, params = "login")
    public void login(Integer number, Integer pin, HttpServletResponse response, HttpServletRequest request) {
        sentResponse(response, index.checkPin(number, pin, request).toString());
    }

    @RequestMapping("operations")
    public String opp(HttpServletRequest request) {
        return opp.opperations(request);
    }

    @RequestMapping("/bank/operations")
    public String operations() {
        return "operations";
    }

    @RequestMapping(value = "/bank/balance", method = RequestMethod.GET)
    public void balance(HttpServletResponse resp, HttpServletRequest request) {
        try {
            Card card = (Card) request.getSession().getAttribute("Card");
            sentResponse(resp, cardToJSON.toJson(card));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/bank/history", method = RequestMethod.GET)
    public void history(Integer limit, Integer start, HttpServletResponse resp, HttpServletRequest request) {
        try {
            Card card = (Card) request.getSession().getAttribute("Card");
            sentResponse(resp, opp.getHistory(card, limit, start));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/bank/transfer", method = RequestMethod.POST)
    public void transfer(Integer to, Double amount, HttpServletRequest r, HttpServletResponse resp) {
        sentResponse(resp, opp.transferMoney(to, amount, r));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest r) {
        r.getSession().removeAttribute("Card");
        r.getSession().removeAttribute("Admin");
        return "redirect:/";
    }

    @RequestMapping(value = "/bank/pay", method = RequestMethod.POST)
    public void pay(Double amount, Integer to, HttpServletRequest r, HttpServletResponse resp) {
        sentResponse(resp, opp.pay(amount, to, r));
    }

    @RequestMapping(value = "/bank/exchange", method = RequestMethod.POST)
    public void transfer(String to, String from, Double amount, HttpServletResponse r) {
        sentResponse(r, opp.exchange(from, to, amount));
    }

    @RequestMapping(value = "/bank/transfercards", method = RequestMethod.GET)
    public void getTransferCards(HttpServletResponse r) {
        sentResponse(r, opp.getTransferCards());
    }

    @RequestMapping(value = "/bank/cards", method = RequestMethod.GET)
    public void getCards(HttpServletResponse r) {
        sentResponse(r, opp.getCurrencies());
    }

    @RequestMapping(value = "/bank/currencies", method = RequestMethod.GET)
    public void getCurrencies(HttpServletResponse r) {
        sentResponse(r, opp.getCurrencies());
    }

    @RequestMapping(value = "/admin/currencies", method = RequestMethod.GET)
    public void getACurrencies(HttpServletResponse r) {
        sentResponse(r, opp.getCurrencies());
    }

    @RequestMapping(value = "/admin/cards", method = RequestMethod.GET)
    public void getAllCards(HttpServletResponse r) {
        sentResponse(r, admin.getCards());
    }

    @RequestMapping(value = "/admin/blockedcards", method = RequestMethod.GET)
    public void getBlockedCards(HttpServletResponse r) {
        sentResponse(r, admin.getBlockedCards());
    }

    @RequestMapping(value = "/admin/blocked", method = RequestMethod.GET)
    public void getBlockedStates(HttpServletResponse r) {
        sentResponse(r, admin.getBlockedValues());
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public void add(String name, String surname, String currency, String blocked, double amount, Integer pin, HttpServletResponse r) {
        Card card = new Card();
        card.setAmount(amount);
        card.setBlocked(blocked);
        card.setCurrency(currency);
        card.setName(name);
        card.setSurname(surname);
        card.setPin(pin);
        card.setAttemps(3);
        cardService.addCard(card);
        card.setPin(HashPin.hash(pin,card.getId()));
        cardService.update(card);
        System.out.println(card.getPin());
        sentResponse(r, admin.addCard(card));
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public void add(Integer id, HttpServletResponse r) {
        sentResponse(r, admin.removeCard(id));
    }

    @RequestMapping(value = "/admin/unblock", method = RequestMethod.POST)
    public void unblock(Integer id, HttpServletResponse r) {
        sentResponse(r, admin.unblockCard(id));
    }

    @RequestMapping(value = "/administrate", method = RequestMethod.GET)
    public String administrate() {
        return "adminLogin";

    }

    @RequestMapping(value = "/administrate", method = RequestMethod.POST)
    public void adminLogin(String login, String pass, HttpServletResponse r, HttpServletRequest req) {
        JSONObject json = new JSONObject();
        if (login.equals("admin") && pass.equals("admin")) {
            try {
                req.getSession().setAttribute("admin", true);
                json.put("success", true);
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } else {
            try {
                json.put("success", false);
            } catch (JSONException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        sentResponse(r, json.toString());
    }

    private void sentResponse(HttpServletResponse r, String jResponse) {
        r.setContentType("application/x-www-form-urlencoded");
        try {
            PrintWriter pw = r.getWriter();
            pw.append(jResponse);
            pw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}