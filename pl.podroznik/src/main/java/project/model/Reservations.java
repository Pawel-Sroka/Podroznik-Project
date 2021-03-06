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
@EqualsAndHashCode(exclude = "users")
public class Reservations {
    @Id
    @GeneratedValue
    private Long reservationId;
    private ReservationStatus status;
    @ManyToOne
    private Users users;


}
