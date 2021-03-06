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



}
