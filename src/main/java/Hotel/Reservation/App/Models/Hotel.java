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
public class Hotel {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> room;
}