package project.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"driversSet", "vehiclesSet", "transit"})
public class TransportCompany {
    @Id
    @GeneratedValue
    private Long companyId;
    private String companyName;
    @ManyToOne
    private Transit transit;
    @OneToMany(mappedBy = "company")
    private Set<Drivers> driversSet = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Vehicles> vehiclesSet = new HashSet<>();

    public void addVehicle (Vehicles vehicle) {
        vehiclesSet.add(vehicle);
        vehicle.setCompany(this);
    }

    public void addDriver (Drivers driver) {
        driversSet.add(driver);
        driver.setCompany(this);
    }

}
