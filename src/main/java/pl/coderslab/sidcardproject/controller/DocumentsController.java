	package pl.coderslab.sidcardproject.controller;

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
import pl.coderslab.sidcardproject.entity.Documents;
import pl.coderslab.sidcardproject.repository.CitizenRepository;
import pl.coderslab.sidcardproject.repository.DocumentsRepository;

@Controller
@RequestMapping("/documents")
public class DocumentsController {
	@Autowired
	DocumentsRepository dr;
	@Autowired
	CitizenRepository cr;

	

	@GetMapping("/printdo/{citizen_id}")
	public String printDo(Model d, @PathVariable long citizen_id) {

		d.addAttribute("citizen", cr.findOne(citizen_id));

		return "documents/printdo";
	}

	@GetMapping("/add/{citizen_id}")
	public String add(Model d, @PathVariable long citizen_id) {
		
		d.addAttribute("documents", new Documents(cr.findOne(citizen_id)));

		return "documents/add";
	}

	@PostMapping("/add/*")//w metodzie get mam parametr
	public String addPost(Model m, @Valid @ModelAttribute Documents documents, BindingResult br) {//przekazujê model dalej
		long id = documents.getCitizen().getId();  //pobieram id z dokumentów
		dr.save(documents); //zapisuje dokument
		m.addAttribute("citizenfulldata", cr.findOne(id)); //³adujê atrybuty na nowo
		
		m.addAttribute("documents", dr.findAllByCitizenId(id));
		
		
		return "documents/documents";//wracam do widoku citizena oraz wszystkich jego dowodów

	}
	
	
	

	@GetMapping("findcitizen")
	public String findCitizenByPesel(Model m) {
		m.addAttribute("citizen", new Citizen());

		return "documents/findcitizen";
	}

	@PostMapping("findcitizen")
	public String findCitizenByPeselPost(@Valid @ModelAttribute Citizen citizen, BindingResult br, Model m) {
		if (br.hasFieldErrors("pesel")) {
			return "documents/findcitizen";
		}

		if (this.cr.findCitizenByPesel(citizen.getPesel()) != null) {
			m.addAttribute("citizenfulldata", this.cr.findOne(this.cr.findCitizenByPesel(citizen.getPesel()).getId()));
			m.addAttribute("documents", dr.findAllByCitizenId(this.cr.findCitizenByPesel(citizen.getPesel()).getId()));
			return "documents/documents";
		} else {

			m.addAttribute("message", "Nie ma w bazie");
			return "documents/findcitizen";

		}

		
	}

}
