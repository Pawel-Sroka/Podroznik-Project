package project.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"transportCompany",
        "vehicle",
        "ticketsSet",
        "departurNode",
        "arrivalNode"})
@ToString(exclude = {"transportCompany",
        "vehicle",
        "ticketsSet",
        "departurNode",
        "arrivalNode",})
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
    @ManyToOne
    private TransportCompany transportCompany;

    @ManyToOne
    private Vehicles vehicle;

    @OneToMany(mappedBy = "transit")
    private Set<Tickets> ticketsSet = new HashSet<>();

    public void addTicket(Tickets tickets) {
        ticketsSet.add(tickets);
        tickets.setTransit(this);
    }





}
