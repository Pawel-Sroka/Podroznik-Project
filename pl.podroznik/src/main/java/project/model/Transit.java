package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Transit {
    @Id
    @GeneratedValue
    private Long transitId;
    private LocalDateTime departueTime;//TODO if have time, change to zoned datetime
    private LocalDateTime arrivalTime;
    @ManyToOne
    private ComunicationNode arrivalNode;
    @ManyToOne
    private ComunicationNode departurNode;

    @OneToMany(mappedBy = "transit")
    private Set<TransportCompany> transportCompanySet = new HashSet<>();

    @OneToMany(mappedBy = "transit")
    private Set<Vehicles> vehiclesSet = new HashSet<>();

    @OneToMany(mappedBy = "transit")
    private Set<Tickets> ticketsSet = new HashSet<>();

    public void addTicket(Tickets tickets) {
        ticketsSet.add(tickets);
        tickets.setTransit(this);
    }

    public void addVehicle (Vehicles vehicle) {
        vehiclesSet.add(vehicle);
        vehicle.setTransit(this);
    }

    public void addTransportCompany (TransportCompany company) {
        transportCompanySet.add(company);
        company.setTransit(this);
    }

}
