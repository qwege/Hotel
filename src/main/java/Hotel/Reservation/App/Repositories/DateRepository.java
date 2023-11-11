package Hotel.Reservation.App.Repositories;

import Hotel.Reservation.App.Models.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date,Long> {
}
