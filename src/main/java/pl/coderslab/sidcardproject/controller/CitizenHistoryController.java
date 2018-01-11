package pl.coderslab.sidcardproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.sidcardproject.repository.CitizenHistoryRepository;

@Controller
@RequestMapping("/citizenhistory")
public class CitizenHistoryController {
	@Autowired
	CitizenHistoryRepository chr;
	
	
	@GetMapping("/show")
	public String showHistory(Model h) {
		h.addAttribute("citizenhistory", this.chr.findAll());
		return "citizenhistory/show";
	}
	
	
	@PostMapping("/showbypesel")
	public String showHistoryPost(@RequestParam(value = "pesel") String pesel, Model m) {
		
		m.addAttribute("citizenlist", this.chr.findCitizenByPesel(pesel));
		m.addAttribute("citizenhistory", this.chr.findAll());
		
		
		return "citizenhistory/show";
	}
	

}
