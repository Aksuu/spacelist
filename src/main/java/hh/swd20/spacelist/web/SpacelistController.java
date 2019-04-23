package hh.swd20.spacelist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.spacelist.domain.ItemRepository;

@Controller
public class SpacelistController {
	
	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("items", itemRepository.findAll());
		return "index";
	}
	
}