package Hotel.Reservation.App.Controllers;

import Hotel.Reservation.App.Models.*;
import Hotel.Reservation.App.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/avaiable")
    public List<Date> getAvaiable(@RequestParam long hotel_id, @RequestParam long room_id) {
        return reservationService.getAvaiable(hotel_id, room_id);
    }

    @GetMapping("/my")
    public List<Reservation> getMyReservation(@RequestParam long session_id) {
        return reservationService.getMyReservation(session_id);
    }

    @PutMapping("/create")
    public boolean createReservation(@RequestParam long room_id, @RequestParam List<java.util.Date> dates, @RequestParam long session_id) {
        return reservationService.createReservation(room_id, dates, session_id);
    }

    @GetMapping("/by_Status")
    public List<Reservation> getReservationByStatus(@RequestParam String status, @RequestParam long session_id) {
        StatusReservation statusReservation = switch (status) {
            case "NEWUNPAID" -> StatusReservation.NEWUNPAID;
            case "NEWPAID" -> StatusReservation.NEWPAID;
            case "CONFIRMED" -> StatusReservation.CONFIRMED;
            case "CANCELLED" -> StatusReservation.CANCELLED;
            case "DURINGDATE" -> StatusReservation.DURINGDATE;
            case "FINISED" -> StatusReservation.FINISED;
            default -> null;
        };

        return reservationService.getReservationByStatus(statusReservation, session_id);

    }

    @PostMapping("/confirm")
    public boolean confirmReservation(@RequestParam long reservation_id, @RequestParam long session_id) {
        return reservationService.confirmReservation(reservation_id, session_id);
    }

    @PostMapping("/cancel")
    public boolean cancelReservation(@RequestParam long reservation_id, @RequestParam long session_id) {
        return reservationService.cancelReservation(reservation_id, session_id);
    }

    @PostMapping("/start")
    public boolean beginDate(@RequestParam long reservation_id, @RequestParam long session_id) {
        return reservationService.beginDate(reservation_id, session_id);
    }

    @PostMapping("/paid")
    public boolean confirmPay(@RequestParam long reservation_id) {
        return reservationService.confirmPay(reservation_id);
    }

    @PostMapping("/end")
    public boolean endDate(@RequestParam long reservation_id, @RequestParam long session_id) {
        return reservationService.endDate(reservation_id, session_id);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservation(@RequestParam long session_id) {
        return reservationService.getAllReservation(session_id);
    }
}
