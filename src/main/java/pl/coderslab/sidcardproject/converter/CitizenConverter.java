package pl.coderslab.sidcardproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.sidcardproject.entity.Citizen;
import pl.coderslab.sidcardproject.repository.CitizenRepository;



public class CitizenConverter implements Converter<String, Citizen> {
	@Autowired
	private CitizenRepository cr;

	
	public Citizen convert(String source) {
		return cr.findOne(Long.parseLong(source));
	}
	
	
}

