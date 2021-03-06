package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Tickets {
    @Id
    @GeneratedValue
    private Long ticketId;
    private Long price;
    @ManyToOne
    private Transit transit;

}
