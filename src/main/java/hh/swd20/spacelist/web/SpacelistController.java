package hh.swd20.spacelist.web;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.spacelist.domain.ItemRepository;
import hh.swd20.spacelist.domain.APODRepository;
import hh.swd20.spacelist.domain.Item;

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
	public String apod(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("categories", itemRepository.findAll());
	return "APODpage";
	}
	
	@PostMapping("/save")
	public String save(Item item) {
		itemRepository.save(item);
		return "redirect:index";
	}
	
//	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addItem")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("categories", itemRepository.findAll());
		return "addItem";
	}
	
	@GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long itemId, Model model) {
    	itemRepository.deleteById(itemId);
        return "redirect:../index";
    }
	
}