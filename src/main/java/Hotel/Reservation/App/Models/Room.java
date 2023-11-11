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
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    private int number;

    private String city;

    private String street;

    private String description;

    @ManyToOne
    private Hotel hotel;

    @OneToMany (mappedBy = "room", cascade = CascadeType.ALL)
    private List<Date> date;
}
