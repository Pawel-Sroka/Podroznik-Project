package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private VehicleType vehicleType;
    @ManyToOne
    private Transit transit;
    @ManyToOne
    private TransportCompany company;
    @ManyToMany(mappedBy = "vehiclesSet")//iw vehicle jest opis relacji
    private Set<Drivers> driverSet = new HashSet<>();

}
