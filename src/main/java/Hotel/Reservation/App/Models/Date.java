package Hotel.Reservation.App.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "date_seq")
    @SequenceGenerator(name="date_seq",sequenceName="date_seq", initialValue = 590)
    private long id;

    @ManyToOne
    private Room room;

    private java.sql.Date date;

    @JsonIgnore
    @ManyToOne (cascade = CascadeType.ALL)
    private Reservation reservation;
}
