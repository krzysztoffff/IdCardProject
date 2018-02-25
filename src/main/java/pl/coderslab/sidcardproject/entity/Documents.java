package pl.coderslab.sidcardproject.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	@Size(min=5, max=10)
	@Pattern(regexp = "^((?!(.*<.*>.*)).)*$", message = "Nie wpisuj skryptów!")
	private String idCardNumber;
	private String photo;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfIssue;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate;
	

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	private Citizen citizen;

	public Documents() {
		super();
	}

	public Documents(String idCardNumber, String photo, LocalDate dateOfIssue, LocalDate expiryDate, LocalDate expiryDate2,
			Citizen citizen) {
		super();
		this.idCardNumber = idCardNumber;
		this.photo = photo;
		this.dateOfIssue = dateOfIssue;
		this.expiryDate = expiryDate;
		this.citizen = citizen;
	}

	public Documents(Citizen citizen) {
		this.citizen = citizen;
	}

	public Documents(long id, String idCardNumber, String photo, LocalDate dateOfIssue, LocalDate expiryDate,
			 Citizen citizen) {
		super();
		this.id = id;
		this.idCardNumber = idCardNumber;
		this.photo = photo;
		this.dateOfIssue = dateOfIssue;
		this.expiryDate = expiryDate;
		this.citizen = citizen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	

}
