package appointments.appointments.service;

import appointments.appointments.model.Appointment;
import appointments.appointments.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
    @Autowired
    IAppointmentRepository repo;

    @Override
    public List<Appointment> getAppointments() {
        return repo.findAll();
    }

    @Override
    public Appointment getAppoById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void saveAppo(Appointment appo) {
        repo.save(appo);
    }

    @Override
    public void editAppo(Long id, Appointment appo) {
        Appointment appointment = this.getAppoById(id);
        if(appointment != null){
            appointment.setDate(appo.getDate());
            appointment.setTreatment(appo.getTreatment());
            //aca se obtiene el nombre completo del paciente desde el servicio paciente
            this.saveAppo(appointment);
        }
    }

    @Override
    public void deleteAppo(Long id) {
        repo.deleteById(id);
    }
}
