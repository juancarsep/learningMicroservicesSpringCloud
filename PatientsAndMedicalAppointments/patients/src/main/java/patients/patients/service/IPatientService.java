package patients.patients.service;


import patients.patients.model.Patient;

import java.util.List;

public interface IPatientService {
    public List<Patient> getPatients();
    public Patient findPatient(Long id);
    public void savePatient(Patient p);
    public void editPatient(Long id, Patient p);
    public void deletePatient(Long id);
    public Patient findPatientByDni(String dni);
}
