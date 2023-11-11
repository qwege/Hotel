package Hotel.Reservation.App.Repositories;

import Hotel.Reservation.App.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
