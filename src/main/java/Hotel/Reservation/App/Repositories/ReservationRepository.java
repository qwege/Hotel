package Hotel.Reservation.App.Repositories;

import Hotel.Reservation.App.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {


}
