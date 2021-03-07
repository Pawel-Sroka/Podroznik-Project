package project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"departue", "arrivalNode"})
public class CommunicationNode {
    @Id
    @GeneratedValue
    private Long nodeId;
    private String nodeName;
    private String nodeCity;
    private String nodeAdress;
    @OneToMany(mappedBy = "arrivalNode")
    private Set<Transit> arrivals = new HashSet<>();
    @OneToMany(mappedBy = "departurNode")
    private Set<Transit> departue = new HashSet<>();

    public void addArrival(Transit transit){
        arrivals.add(transit);
        transit.setArrivalNode(this);
    }
    public void addDepartue(Transit transit){
        departue.add(transit);
        transit.setDeparturNode(this);
    }


}
