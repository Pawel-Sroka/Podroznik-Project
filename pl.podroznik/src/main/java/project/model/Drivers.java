package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Drivers {
    @Id
    @GeneratedValue
    private Long driverId;
    private String driverFirstName;
    private String driverLastName;
    private Integer rate;
}
