package Hotel.Reservation.App.Repositories;

import Hotel.Reservation.App.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
