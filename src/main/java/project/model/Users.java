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
@EqualsAndHashCode(exclude = "reservationsSet")
public class Users {
    @Id
    @GeneratedValue
    private Long userId;
    private String userPersonalId;
    private String userFirstName;
    private String userLastName;
    @OneToMany(mappedBy = "users")
    private Set<Reservations> reservationsSet = new HashSet<>();

    public void addReservation(Reservations reservation) {
        reservationsSet.add(reservation);
        reservation.setUsers(this);
    }


}
