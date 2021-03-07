package project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"transit", "reservations"})
@ToString(exclude = {"transit", "reservations"})
public class Tickets {
    @Id
    @GeneratedValue
    private Long ticketId;
    private Double price;
    @ManyToOne
    private Reservations reservations;
    @ManyToOne
    private Transit transit;

}
