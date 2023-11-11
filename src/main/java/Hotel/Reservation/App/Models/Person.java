package Hotel.Reservation.App.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String surname;

    private String login;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private TypeUser uprawnienia;

    @OneToMany (mappedBy = "person",cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}