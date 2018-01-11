package pl.coderslab.sidcardproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.sidcardproject.entity.CitizenHistory;

public interface CitizenHistoryRepository extends JpaRepository<CitizenHistory, Long> {
	
	
	
	@Query("SELECT c FROM CitizenHistory c WHERE c.pesel LIKE :pesel% ORDER BY c.actionTime DESC")
	public List<CitizenHistory> findCitizenByPesel(@Param("pesel") String pesel);

}
