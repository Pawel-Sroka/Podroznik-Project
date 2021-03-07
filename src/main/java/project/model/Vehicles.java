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
@EqualsAndHashCode(exclude = {"driverSet", "company", "transitSet"})
@ToString(exclude = {"driverSet", "company", "transitSet"})
public class Vehicles {
    @Id
    @GeneratedValue
    private Long VehicleId;
    private String vehicleName;
    private Integer seatsNumber;
    private VehicleType vehicleType;
    @OneToMany (mappedBy = "vehicle")
    private Set<Transit> transitSet = new HashSet<>();
    @ManyToOne
    private TransportCompany company;
    @ManyToMany(mappedBy = "vehiclesSet")//w drivers jest opis relacji
    private Set<Drivers> driverSet = new HashSet<>();

    public void addDriver(Drivers drivers){
        driverSet.add(drivers);
        drivers.addVehicle(this);
    }

    public void addTransit (Transit transit) {
        transitSet.add(transit);
        transit.setVehicle(this);
    }
}
