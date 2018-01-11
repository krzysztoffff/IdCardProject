package pl.coderslab.sidcardproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.sidcardproject.entity.Documents;

public interface DocumentsRepository extends JpaRepository<Documents, Long> {
	
	@Query("SELECT d FROM Documents d WHERE d.citizen.id = :id ORDER BY d.id DESC")
	public List<Documents> findAllByCitizenId(@Param("id") long id);
	
	

}
