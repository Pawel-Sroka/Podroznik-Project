package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ComunicationNode {
    @Id
    @GeneratedValue
    private Long nodeId;
    private String nodeName;
    private String nodeCity;
    private String nodeAdress;

}
