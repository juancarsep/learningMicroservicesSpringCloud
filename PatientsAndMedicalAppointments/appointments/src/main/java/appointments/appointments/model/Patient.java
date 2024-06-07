package appointments.appointments.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Patient {

    private Long id;
    private String name;
    private String lastname;
    private Date birthDate;
    private String mobile;
}
