package patients.patients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patients.patients.model.Patient;
import patients.patients.service.IPatientService;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private IPatientService service;

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return service.getPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return service.findPatient(id);
    }

    @PostMapping("/patients")
    public void savePatient(@RequestBody Patient pat){
        service.savePatient(pat);
    }

    @PutMapping("/patients/{id}")
    public void editPatient(@PathVariable Long id,
                            @RequestBody Patient pat){
        service.editPatient(id, pat);
    }

    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id){
        service.deletePatient(id);
    }

    @GetMapping("/patients/getdni/{dni}")
    public Patient getPatientByDni(@PathVariable String dni){
        return service.findPatientByDni(dni);
    }
}
