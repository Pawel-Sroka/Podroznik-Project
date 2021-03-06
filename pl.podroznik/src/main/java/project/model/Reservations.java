package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Reservations {
    @Id
    @GeneratedValue
    private Long reservationId;
    private ReservationStatus status;


}
