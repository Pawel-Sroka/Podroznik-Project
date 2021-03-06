package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Vehicles {
    @Id
    @GeneratedValue
    private Long VehicleId;
    private String vehicleName;
    private Integer seatsNumber;
    private String vehicleType;
}
