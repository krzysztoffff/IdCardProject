package pl.coderslab.sidcardproject.entity;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class CitizenHistory {
	
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotEmpty
    private String street;
    @NotEmpty
    private String numberOfBuilding;
    @NotEmpty
    private String city;
    @Column(name = "postalCode", length = 6)
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]")
    private String postalCode;
    private String action;
    private Date actionTime;
    
    
	




	public CitizenHistory() {
    	super();
    }
    
   

	public CitizenHistory(String pesel, String firstName, String secondName, String lastName, 
			String sex, LocalDate dateOfBirth, String street, String numberOfBuilding, String city,
			String postalCode, String action, Date actionTime) {
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
		this.action = action;
		this.actionTime = actionTime;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		
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



	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}
    
    public Date getActionTime() {
		return actionTime;
	}



	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}
	
	
	

	

}
