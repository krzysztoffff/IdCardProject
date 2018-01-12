package pl.coderslab.sidcardproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.sidcardproject.entity.CitizenHistory;
import pl.coderslab.sidcardproject.repository.CitizenHistoryRepository;

@Controller
@RequestMapping("/citizenhistory")
public class CitizenHistoryController {
	@Autowired
	CitizenHistoryRepository chr;

	@GetMapping("/show")
	public String showHistory(Model h) {
		h.addAttribute("findcitizenhistory", new CitizenHistory());
		h.addAttribute("citizenhistory", this.chr.findAll());
		return "citizenhistory/show";
	}

	@PostMapping("/show")
	public String showHistoryPost2(@Valid @ModelAttribute CitizenHistory findcitizenhistory, BindingResult br, Model h) {
		
		if (br.hasFieldErrors("pesel")) {
			
			return "citizenhistory/show";
			
		} else {
			h.addAttribute("citizenhistory", this.chr.findAll());
			h.addAttribute("findcitizenhistory", new CitizenHistory());
			h.addAttribute("onecitizenhistory", this.chr.findCitizenByPesel(findcitizenhistory.getPesel()));
			return "citizenhistory/show";

		}

	}


}
