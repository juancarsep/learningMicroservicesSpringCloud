package appointments.appointments.repository;

import appointments.appointments.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patientsApi", url="http://localhost:9001")
public interface IPatientAPIClient {
    @GetMapping("/patients/getdni/{dni}")
    public Patient getPatient(@PathVariable ("dni") String dni);
}
