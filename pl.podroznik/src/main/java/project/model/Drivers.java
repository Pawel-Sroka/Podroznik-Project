package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(
            name = "vehicles_of_driver",
            joinColumns = @JoinColumn(name = "vehicle_id"), // tu trzeba nazwy z tabeli pobrac jakie sie utworza
            inverseJoinColumns = @JoinColumn(name = "driver_id")
    )
    private Set<Vehicles> vehiclesSet = new HashSet<>();

    public void addVehicle(Vehicles vehicles){
        vehiclesSet.add(vehicles);
        vehicles.getDriverSet().add(this);
    }

}
