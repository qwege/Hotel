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
public class Hotel {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "hotel_seq")
    @SequenceGenerator(name="hotel_seq",sequenceName="hotel_seq", initialValue = 6)
    private long id;

    private String name;

    @OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> room;
}
