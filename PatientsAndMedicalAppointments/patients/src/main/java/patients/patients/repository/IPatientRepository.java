package patients.patients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import patients.patients.model.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.dni = :dni")
    public Patient findByDni(@Param("dni") String dni);
}
