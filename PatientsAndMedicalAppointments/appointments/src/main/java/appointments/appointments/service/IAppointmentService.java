package appointments.appointments.service;

import appointments.appointments.dto.AppointmentDTO;
import appointments.appointments.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    public List<Appointment> getAppointments();
    public Appointment getAppoById(Long id);
    public void editAppo(Long id, Appointment appo);
    public void deleteAppo(Long id);
    public void saveAppo(AppointmentDTO appointmentDTO);
}
