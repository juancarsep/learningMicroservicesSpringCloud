package appointments.appointments.controller;

import appointments.appointments.dto.AppointmentDTO;
import appointments.appointments.model.Appointment;
import appointments.appointments.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    IAppointmentService service;

    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){
        return service.getAppointments();
    }

    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return service.getAppoById(id);
    }

    @PostMapping("/appointments")
    public void saveAppointment(@RequestBody AppointmentDTO appointmentDTO){
        service.saveAppo(appointmentDTO);
    }

    @PutMapping("/appointments/{id}")
    public void editAppointment(@PathVariable Long id,
                                @RequestBody Appointment appo){
        service.editAppo(id, appo);
    }

    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable Long id){
        service.deleteAppo(id);
    }
}
