package project.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"driverSet", "company", "transit"})
@ToString(exclude = {"driverSet", "company", "transit"})
public class Vehicles {
    @Id
    @GeneratedValue
    private Long VehicleId;
    private String vehicleName;
    private Integer seatsNumber;
    private VehicleType vehicleType;
    @ManyToOne
    private Transit transit;
    @ManyToOne
    private TransportCompany company;
    @ManyToMany(mappedBy = "vehiclesSet")//w drivers jest opis relacji
    private Set<Drivers> driverSet = new HashSet<>();

    public void addDriver(Drivers drivers){
        driverSet.add(drivers);
        drivers.addVehicle(this);
    }
}
