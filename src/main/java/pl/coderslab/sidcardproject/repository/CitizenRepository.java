package pl.coderslab.sidcardproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.sidcardproject.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
	
	@Query("SELECT c FROM Citizen c WHERE c.pesel LIKE :pesel%")
	public Citizen findCitizenByPesel(@Param("pesel") String pesel);

}
