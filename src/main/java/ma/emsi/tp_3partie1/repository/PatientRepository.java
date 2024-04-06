package ma.emsi.tp_3partie1.repository;

import ma.emsi.tp_3partie1.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
  Page<Patient> findByNomContains(String keyword, Pageable pageable);

}
