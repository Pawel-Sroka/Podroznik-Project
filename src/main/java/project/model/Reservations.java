package project.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"ticketsSet", "users"})
public class Reservations {
    @Id
    @GeneratedValue
    private Long reservationId;
    private ReservationStatus status;
    @ManyToOne
    private Users users;
    @OneToMany(mappedBy = "reservations")
    private Set<Tickets> ticketsSet = new HashSet<>();

    public void addTicket(Tickets tickets) {
        ticketsSet.add(tickets);
        tickets.setReservations(this);
    }


}
