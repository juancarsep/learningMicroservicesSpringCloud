package appointments.appointments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AppointmentDTO {
    private LocalDate date;
    private String treatment;
    private String dni;
}
