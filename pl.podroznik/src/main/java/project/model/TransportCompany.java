package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class TransportCompany {
    @Id
    @GeneratedValue
    private Long companyId;
    private String companyName;
    @OneToMany(mappedBy = "transportCompany")
    private Set<Drivers> driversSet = new HashSet<>();

    @OneToMany(mappedBy = "transportCompany")
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
