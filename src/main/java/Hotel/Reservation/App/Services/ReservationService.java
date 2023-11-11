package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.*;

import java.util.List;

public interface ReservationService {

        List<Date> getAvaiable(Hotel hotel, Room room);
        List<Reservation> getMyReservation(long session_id);
        boolean createReservation(Room room, List<java.util.Date> dates, Person person);
        List<Reservation> getReservationByStatus(StatusReservation status,long session_id);
        boolean confirmReservation(long reservation_id,long session_id);
        boolean cancelReservation(long reservation_id,long session_id);
        boolean beginDate(long reservation_id,long session_id);
        boolean confirmPay(long reservation_id);
        boolean endDate(long reservation_id,long session_id);
        List<Reservation> getAllReservation(long session_id);


}
