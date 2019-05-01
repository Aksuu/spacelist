package hh.swd20.spacelist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.spacelist.domain.ItemRepository;
import hh.swd20.spacelist.domain.APODRepository;

@Controller
public class SpacelistController {
	
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	private APODRepository apodRepository;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("items", itemRepository.findAll());
		model.addAttribute("apods", apodRepository.findAll());
		return "index";
	}
	
	@GetMapping("/search")
	public String search() {
	return "nasaSearch";
	}
	
	@GetMapping("/APOD")
	public String apod() {
	return "APODpage";
	}
	
}