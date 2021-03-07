package project.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"transit", "reservations"})
public class Tickets {
    @Id
    @GeneratedValue
    private Long ticketId;
    private Long price;
    @ManyToOne
    private Reservations reservations;
    @ManyToOne
    private Transit transit;

}
