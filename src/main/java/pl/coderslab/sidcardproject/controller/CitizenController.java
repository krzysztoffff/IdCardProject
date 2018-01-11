package pl.coderslab.sidcardproject.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.sidcardproject.entity.Citizen;
import pl.coderslab.sidcardproject.entity.CitizenHistory;
import pl.coderslab.sidcardproject.repository.CitizenHistoryRepository;
import pl.coderslab.sidcardproject.repository.CitizenRepository;

@Controller
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	CitizenRepository cr;
	@Autowired
	CitizenHistoryRepository chr;

	@GetMapping("/add")
	public String add(Model c) {
		c.addAttribute("citizen", new Citizen());

		return "citizen/add";
	}

	@PostMapping("/add")
	public String addPost(@Valid @ModelAttribute Citizen citizen, BindingResult br) {
		if (br.hasErrors()) {
			return "citizen/add";
		} else {
			this.cr.save(citizen);
			this.chr.save(CitizenToHistory(citizen, "Utworzony"));
			return "redirect:/citizen/all";
		}
	}

	@GetMapping("/all")
	public String showAll(Model c) {
		c.addAttribute("citizens", cr.findAll());
		return "citizen/citizens";
	}

	@GetMapping("/edit/{id}")
	public String editCitizen(Model c, @PathVariable long id) {
		c.addAttribute("citizen", cr.findOne(id));
		return "citizen/add";
	}

	@PostMapping("/edit/{id}")
	public String editCitizenPost(@Valid @ModelAttribute Citizen citizen, BindingResult br) {
		if (br.hasErrors()) {
			return "citizen/add";
		} else {
			this.cr.save(citizen);

			this.chr.save(CitizenToHistory(citizen, "edytowany"));

			return "redirect:/citizen/all";

		}
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		
		this.chr.save(CitizenToHistory(cr.findOne(id), "Usuniêty"));
		cr.delete(id);
		return "redirect:/citizen/all";
	}

	
	
	public CitizenHistory CitizenToHistory(Citizen citizen, String action) {
		CitizenHistory ch = new CitizenHistory(citizen.getPesel(), citizen.getFirstName(), citizen.getSecondName(),
				citizen.getLastName(), citizen.getSex(), citizen.getDateOfBirth(), citizen.getStreet(),
				citizen.getNumberOfBuilding(), citizen.getCity(), citizen.getPostalCode(), action, new Date());
		return ch;
	}

}
