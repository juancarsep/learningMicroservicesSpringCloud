package appointments.appointments.service;

import appointments.appointments.dto.AppointmentDTO;
import appointments.appointments.model.Appointment;
import appointments.appointments.model.Patient;
import appointments.appointments.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
    @Autowired
    private IAppointmentRepository repo;
    @Autowired
    private RestTemplate consumeApi;

    @Override
    public List<Appointment> getAppointments() {
        return repo.findAll();
    }

    @Override
    public Appointment getAppoById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void saveAppo(AppointmentDTO appointmentDTO) {

        Patient pat = consumeApi.getForObject("http://localhost:9001/patients/getdni/" + appointmentDTO.getDni(), Patient.class);

        if(pat != null){
            String fullname = pat.getName() + " " + pat.getLastname();
            Appointment appo = new Appointment();
            appo.setDate(appointmentDTO.getDate());
            appo.setTreatment(appointmentDTO.getTreatment());
            appo.setPatientFullNAme(fullname);
            repo.save(appo);
        }else{
            System.out.println("EL CLIENTE RECUPERADO ES NULO");
        }
    }

    @Override
    public void editAppo(Long id, Appointment appo) {
        Appointment appointment = this.getAppoById(id);
        if(appointment != null){
            appointment.setDate(appo.getDate());
            appointment.setTreatment(appo.getTreatment());
            //aca se obtiene el nombre completo del paciente desde el servicio paciente
            repo.save(appointment);
        }
    }

    @Override
    public void deleteAppo(Long id) {
        repo.deleteById(id);
    }
}
