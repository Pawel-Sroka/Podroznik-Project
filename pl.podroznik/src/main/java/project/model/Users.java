package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue
    private Long userId;
    private String userPersonalId;
    private String userFirstName;
    private String userLastName;
    @OneToMany(mappedBy = "Users")
    private Set<Reservations> reservationsSet = new HashSet<>();

    public void addReservation(Reservations reservation){
        reservationsSet.add(reservation);
        reservation.setUser(this);
    }



}
