	package pl.coderslab.sidcardproject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.coderslab.sidcardproject.bean.SessionManager;
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
	private static String UPLOADED_FOLDER = "F://workspace//IdCardProject//src//main//webapp//resources//images//";
//	private static String UPLOADED_FOLDER = "//usr//home//krzysztoffff//tomcat//webapps//IdCardProject//resources//images//";
	

	@GetMapping("/printdo/{citizen_id}")
	public String printDo(Model d, @PathVariable long citizen_id) {

		d.addAttribute("citizen", cr.findOne(citizen_id));
		

		return "documents/printdo";
	}

	@GetMapping("/add2/{citizen_id}")
	public String addWithPhoto(Model d, @PathVariable long citizen_id) {
		
		HttpSession s = SessionManager.session();
        s.setAttribute("citizen", cr.findOne(citizen_id));
		
//		d.addAttribute("documents", new Documents(cr.findOne(citizen_id)));
        
		return "documents/addwithphoto";
	}
	
	@PostMapping("/upload")
	public String uploadPicture(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes, Model m) {
		HttpSession s = SessionManager.session();
		Citizen citizen = (Citizen) s.getAttribute("citizen");
		
		List <Documents> docs = new ArrayList();  //initialize citizens documents list
		docs = dr.findAllByCitizenId(citizen.getId()); //take documents from database
		int docsQuantity = docs.size(); //initialize and set number of documents
		String partFileName = Integer.toString(docsQuantity); //initialize string which will be a part of future unique file picture file name
		
		 if (file.isEmpty()) { // when file from form is not good
			 	m.addAttribute("flashmessage", "Please select a file to upload");
	            return "documents/addwithphoto";
	        }

	        try {

	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + citizen.getPesel() + "x" + partFileName + ".jpg");
	            Files.write(path, bytes);
	            
	            m.addAttribute("flashmessage", "You successfully uploaded '" + file.getOriginalFilename() + "'");
	            m.addAttribute("photook", "forward");
	            String filename = citizen.getPesel() + "x" + partFileName + ".jpg"; //set unique file name to store on server
	            s.setAttribute("photopath", filename); //set file name in session to send it to view

	        } catch (IOException e) {
	        	m.addAttribute("flashmessage", e);
//	            e.printStackTrace();
	        }

	        return "documents/addwithphoto";
		
		
		
		
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
