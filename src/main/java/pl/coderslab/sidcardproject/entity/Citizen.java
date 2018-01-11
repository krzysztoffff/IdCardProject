package pl.coderslab.sidcardproject.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Citizen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotEmpty
	@PESEL
    private String pesel;
	@NotEmpty
    private String firstName;
    private String secondName;
	@NotEmpty
    private String lastName;
    @NotEmpty
    @Column(length = 1)
    @Pattern(regexp = "[M]|[K]")
	private String sex;
    @Column
//    @Type(type="date")
    @DateTimeFormat
    private String dateOfBirth;
    private String street;
    private String numberOfBuilding;
    private String city;
    @Column(name = "postalCode", length = 6)
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]")
    private String postalCode;
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "citizen", cascade = CascadeType.ALL)
	private List<Documents> documents;
    
	
    public Citizen() {
    	super();
    }
    
    
	

	public Citizen(String pesel, String firstName, String secondName, String lastName, 
			String sex, String dateOfBirth, String street, String numberOfBuilding, String city,
			String postalCode) {
		super();
		this.pesel = pesel;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.street = street;
		this.numberOfBuilding = numberOfBuilding;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	

	public Citizen(long id, String pesel, String firstName, String secondName, String lastName, String sex,
			String dateOfBirth, String street, String numberOfBuilding, String city, String postalCode,
			List<Documents> documents) {
		super();
		this.id = id;
		this.pesel = pesel;
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.street = street;
		this.numberOfBuilding = numberOfBuilding;
		this.city = city;
		this.postalCode = postalCode;
		this.documents = documents;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		
		this.dateOfBirth = dateOfBirth;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberOfBuilding() {
		return numberOfBuilding;
	}

	public void setNumberOfBuilding(String numberOfBuilding) {
		this.numberOfBuilding = numberOfBuilding;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}




	public List<Documents> getDocuments() {
		return documents;
	}




	public void setDocuments(List<Documents> documents) {
		this.documents = documents;
	}
    
    
	
	
	

	

}
