package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany(mappedBy = "vehiclesSet")//iw vehicle jest opis relacji
    private Set<Drivers> driverSet = new HashSet<>();

}
