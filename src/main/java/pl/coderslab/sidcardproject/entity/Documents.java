package pl.coderslab.sidcardproject.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String idCardNumber;
	private String photo;
	private String dateOfIssue;
	private String expiryDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expiryDate2;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	private Citizen citizen;

	public Documents() {
		super();
	}

	public Documents(String idCardNumber, String photo, String dateOfIssue, String expiryDate, LocalDate expiryDate2,
			Citizen citizen) {
		super();
		this.idCardNumber = idCardNumber;
		this.photo = photo;
		this.dateOfIssue = dateOfIssue;
		this.expiryDate = expiryDate;
		this.expiryDate2 = expiryDate2;
		this.citizen = citizen;
	}

	public Documents(Citizen citizen) {
		this.citizen = citizen;
	}

	public Documents(long id, String idCardNumber, String photo, String dateOfIssue, String expiryDate,
			LocalDate expiryDate2, Citizen citizen) {
		super();
		this.id = id;
		this.idCardNumber = idCardNumber;
		this.photo = photo;
		this.dateOfIssue = dateOfIssue;
		this.expiryDate = expiryDate;
		this.expiryDate2 = expiryDate2;
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

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public LocalDate getExpiryDate2() {
		return expiryDate2;
	}

	public void setExpiryDate2(LocalDate expiryDate2) {
		this.expiryDate2 = expiryDate2;
	}

}
