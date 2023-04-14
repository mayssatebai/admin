package org.iset.Repositories;

import org.iset.entities.Paiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PaimentRepository extends JpaRepository<Paiment, Long> {

}
