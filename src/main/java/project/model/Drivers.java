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
@EqualsAndHashCode(exclude = {"vehiclesSet", "company"})
@ToString(exclude = {"vehiclesSet", "company"})
public class Drivers {
    @Id
    @GeneratedValue
    private Long driverId;
    private String driverFirstName;
    private String driverLastName;
    private Integer rate;
    @ManyToOne
    private TransportCompany company;
    @ManyToMany
    @JoinTable(
            name = "vehicles_of_driver",
            joinColumns = @JoinColumn(name = "VehicleId"), // tu trzeba nazwy z tabeli pobrac jakie sie utworza
            inverseJoinColumns = @JoinColumn(name = "driverId")
    )
    private Set<Vehicles> vehiclesSet = new HashSet<>();

    public void addVehicle(Vehicles vehicles){
        vehiclesSet.add(vehicles);
        vehicles.getDriverSet().add(this);
    }

}
