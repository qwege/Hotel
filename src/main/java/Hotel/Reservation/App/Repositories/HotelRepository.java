package Hotel.Reservation.App.Repositories;

import Hotel.Reservation.App.Models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
