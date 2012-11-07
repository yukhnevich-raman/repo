package com.atm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.atm.domain.Card;
import com.atm.service.CardService;

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

	@RequestMapping("/index")
	public String index(Model model) {
		index.index(model);
		return "index";
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST, params = "login")
	public String login(Model model, Integer number, Integer pin) {
		return index.checkPin(number, pin);
	}

	@RequestMapping("/opperations")
	public String opp(Model model) {
		opp.opperations(model, index.getCard());
		// opp.reset();
		return "opperations";
	}

	@RequestMapping(value = "/opperations", method = RequestMethod.POST, params = "transfer")
	public String transfer(Model model, Integer to, Double amount) {
		opp.transferMoney(to, amount);
		return "redirect:opperations";
	}

	@RequestMapping(value = "/opperations", method = RequestMethod.POST, params = "exchange")
	public String transfer(Model model, String to, String from, Double amount) {
		opp.exchange(from, to, amount);
		return "redirect:opperations";
	}

	@RequestMapping(value = "/admin")
	public String admin(Model model) {
		admin.admin(model);
		return "admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST, params = "add")
	public String add(Model model, @ModelAttribute("card") Card card,
			BindingResult result) {
		card.setAttemps(3);
		admin.addCard(card);
		return "redirect:admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST, params = "delete")
	public String add(Model model, Integer id) {
		admin.removeCard(id);
		return "redirect:admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST, params = "unblock")
	public String unblock(Model model, Integer id) {
		admin.unblockCard(id);
		return "redirect:admin";
	}

	//
	// @RequestMapping("/delete/{contactId}")
	// public String deleteContact(@PathVariable("contactId") Integer contactId)
	// {
	//
	// contactService.removeContact(contactId);
	//
	// return "redirect:/index";
	// }
}