package org.iset.Repositories;

import org.iset.entities.Parieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ParieurRepository extends JpaRepository<Parieur, Long> {
	
	@Query(value="select * from Parieur where email=?1 and password=?2",nativeQuery=true)
	public Parieur seconnecter(String email, String password);
    
}
