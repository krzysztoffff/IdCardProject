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

import pl.coderslab.sidcardproject.entity.CitizenHistory;
import pl.coderslab.sidcardproject.repository.CitizenHistoryRepository;

@Controller
@RequestMapping("/citizenhistory")
public class CitizenHistoryController {
	@Autowired
	CitizenHistoryRepository chr;

	@GetMapping("/show")
	public String showHistory(Model h) {
		h.addAttribute("findchistory", new CitizenHistory());
		h.addAttribute("citizenhistory", this.chr.findAll());
		return "citizenhistory/show";
	}

	@PostMapping("/show")
	public String showHistoryPost(@Valid @ModelAttribute("findchistory") CitizenHistory findchistory, BindingResult brch,
			Model h) {

		

		if (brch.hasFieldErrors("pesel")) {
			h.addAttribute("citizenhistory", this.chr.findAll());
			return "citizenhistory/show";

		}

		h.addAttribute("citizenhistory", this.chr.findAll());
		h.addAttribute("findchistory", new CitizenHistory());
		h.addAttribute("onecitizenhistory", this.chr.findCitizenByPesel(findchistory.getPesel()));
		return "citizenhistory/show";

	}

}
