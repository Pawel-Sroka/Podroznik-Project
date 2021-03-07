package project.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"transportCompanySet",
        "vehiclesSet",
        "ticketsSet",
        "departurNode",
        "arrivalNode"})
public class Transit {
    @Id
    @GeneratedValue
    private Long transitId;
    private LocalDateTime departueTime;//TODO if have time, change to zoned datetime
    private LocalDateTime arrivalTime;
    @ManyToOne
    private CommunicationNode arrivalNode;
    @ManyToOne
    private CommunicationNode departurNode;

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
