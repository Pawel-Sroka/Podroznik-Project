package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Transit {
    @Id
    @GeneratedValue
    private Long transitId;
    private LocalDateTime departueTime;//TODO if have time, change to zoned datetime
    private LocalDateTime arrivalTime;
    private ComunicationNode arrivalNode;
    private ComunicationNode departurNode;
    @OneToMany
    private Tickets ticket;

}
