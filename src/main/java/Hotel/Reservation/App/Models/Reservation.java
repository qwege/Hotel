package Hotel.Reservation.App.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reservation_seq")
    @SequenceGenerator(name="reservation_seq",sequenceName="reservation_seq", initialValue = 7)
    private long id;

    @OneToMany (mappedBy = "reservation",cascade = CascadeType.ALL)
    private List<Date> date;

    @ManyToOne
    private Person person;

    private int prize;

    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;

}
