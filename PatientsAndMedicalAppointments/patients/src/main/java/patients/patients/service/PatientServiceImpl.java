package patients.patients.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patients.patients.model.Patient;
import patients.patients.repository.IPatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService{

    @Autowired
    IPatientRepository repo;


    @Override
    public List<Patient> getPatients() {
        return repo.findAll();
    }

    @Override
    public Patient findPatient(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void savePatient(Patient p) {
        repo.save(p);
    }

    @Override
    public void editPatient(Long id, Patient p) {
        Patient pat = this.findPatient(id);
        if(pat != null){
            pat.setName(p.getName());
            pat.setLastname(p.getLastname());
            pat.setBirthDate(p.getBirthDate());
            pat.setMobile(p.getMobile());
            this.savePatient(pat);
        }
    }

    @Override
    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
}
