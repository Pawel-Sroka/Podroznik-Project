package project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
