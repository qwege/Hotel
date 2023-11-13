package Hotel.Reservation.App.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "room_seq")
    @SequenceGenerator(name="room_seq",sequenceName="room_seq", initialValue = 20)
    private long id;

    private int number;

    private String city;

    private String street;

    private String description;

    @JsonIgnore
    @ManyToOne
    private Hotel hotel;

    @JsonIgnore
    @OneToMany (mappedBy = "room", cascade = CascadeType.ALL)
    private List<Date> date;
}
