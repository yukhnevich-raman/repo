package com.atm.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atm.domain.Card;
import com.atm.service.CardService;

@Controller
public class CardController {

	@Autowired
	private CardService cardService;
	private Card card;
	private String error;
	private String id;
	private Integer i = 0;

    @RequestMapping("/index")
    public String index(Model model) {
    	model.addAttribute("error", error);
        return "index";
    }
    
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST, params="login")
    public String login(Model model,Integer number,Integer pin) {
    	error = "";
    	card = cardService.getCard(number);
		if(card == null) {
			error = "<h2><font color='red'>Invalid card number! Please try again</font></h2>";
			return "redirect:/index";
		}
		Integer pincode = card.getPin();
		if(!pincode.equals(pin)) {
			if(i<2) {
				i+=1;
				error = "<h2><font color='red'>Invalid pin code! "+(3-i)+" attempts remained </font></h2>";
				return "redirect:/index";
			} else {				
				error = "<h2><font color='red'>Invalid pin code! Your card was blocked!<br/>Insert another card</font></h2>";
				card.setBlocked("y");
				i=0;
				return "redirect:/index";
			}
		} else {
			i=0;
			return "redirect:/opperations";
		}
    }
    
//    @RequestMapping("/add")
//    public String add() {
//    	card = new Card();
//    	card.setAmount(500);
//    	card.setBlocked("n");
//    	card.setCurrencu("BYR");
//    	card.setId(999);
//    	card.setName("Raman");
//    	card.setPin(1234);
//    	card.setSurname("Yukhnevich");
//    	cardService.addCard(card);
//        return "redirect:/index";
//    }
    
    @RequestMapping("/opperations")
    public String opp() {
        return "opperations";
    }
    
    @RequestMapping(value = "/admin")
    public String admin(Model model) {
    	model.addAttribute("card", new Card());
    	model.addAttribute("currency", Currency.values());
    	model.addAttribute("blocked", Blocked.values());
    	model.addAttribute("id",id );
        return "admin";
    }
    
    @RequestMapping(value = "/admin" , method = RequestMethod.POST, params="add")
    public String add(Model model,@ModelAttribute("card") Card card,
            BindingResult result) {
    	cardService.addCard(card);
    	id ="<h2><font color='green'>Card was successfully created. Your card id is: <br/>"+card.getId()+"</font></h2>";
        return "redirect:admin";
    }
//
//    @RequestMapping("/delete/{contactId}")
//    public String deleteContact(@PathVariable("contactId") Integer contactId) {
//
//        contactService.removeContact(contactId);
//
//        return "redirect:/index";
//    }
}