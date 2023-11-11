package Hotel.Reservation.App.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 *  Class represents one day of reservation
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Room room;

    private java.sql.Date date;

    @ManyToOne (cascade = CascadeType.ALL)
    private Reservation reservation;
}
