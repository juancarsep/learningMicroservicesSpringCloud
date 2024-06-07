package appointments.appointments.service;

import appointments.appointments.model.Appointment;

import java.util.List;

public interface IAppointmentService {

    public List<Appointment> getAppointments();
    public Appointment getAppoById(Long id);
    public void saveAppo(Appointment appo);
    public void editAppo(Long id, Appointment appo);
    public void deleteAppo(Long id);
}
