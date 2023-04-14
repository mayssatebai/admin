package org.iset.Repositories;

import java.util.Date;

import org.iset.entities.Pari;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PariRepository extends JpaRepository<Pari, Long> {
	
	@Query(value="select * Pari from  where date=date",nativeQuery=true)
      public Pari getPariByDate(Date date);
}
