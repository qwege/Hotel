package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.*;
import Hotel.Reservation.App.Repositories.DateRepository;
import Hotel.Reservation.App.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    DateRepository dateRepository;
    @Autowired
    HotelService hotelService;
    @Autowired
    UserService userService;

    @Override
    public List<Date> getAvaiable(long hotel_id, long room_id) {
        List<Date> dates = dateRepository.findAll();
        if (room_id != 0)
            dates.removeIf(d -> d.getRoom().getId() != room_id);
        if (hotel_id != 0)
            dates.removeIf(d -> d.getRoom().getHotel().getId() != hotel_id);
        List<Date> fiteredDatas = new ArrayList<>();
        for (Date d : dates) {
            if (d.getReservation() == null) {
                fiteredDatas.add(d);
                continue;
            }
            if (d.getReservation().getStatusReservation() == StatusReservation.CANCELLED) {
                fiteredDatas.add(d);
            }
        }
        return fiteredDatas;
    }

    @Override
    public List<Reservation> getMyReservation(long session_id) {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.removeIf(r -> r.getPerson().getId() != LoggingService.getPersonIdOfSession(session_id));
        return reservations;
    }

    @Override
    public boolean createReservation(long room_id, List<java.util.Date> dates, long session_id) {
        List<Date> dateList = new ArrayList<>();
        for (java.util.Date d : dates) {
            Date date = new Date();
            date.setDate(new java.sql.Date(d.getTime()));
            date.setRoom(hotelService.getRoom(room_id));
            dateList.add(date);
        }
        Reservation reservation = new Reservation();
        reservation.setStatusReservation(StatusReservation.NEWUNPAID);
        reservation.setPrize(100);
        reservation.setPerson(userService.getMyProfile(session_id));
        reservation.setDate(dateList);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public List<Reservation> getReservationByStatus(StatusReservation status, long session_id) {
        if (!checkIsAdmin(session_id)) return null;
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.removeIf(r -> r.getStatusReservation() != status);
        return reservations;
    }

    @Override
    public boolean confirmReservation(long reservation_id, long session_id) {
        if (!checkIsAdmin(session_id)) return false;
        Reservation reservation = reservationRepository.getReferenceById(reservation_id);
        if (reservation.getStatusReservation() == StatusReservation.NEWPAID)
            reservation.setStatusReservation(StatusReservation.CONFIRMED);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public boolean cancelReservation(long reservation_id, long session_id) {
        if (!checkIsAdmin(session_id)) return false;
        Reservation reservation = reservationRepository.getReferenceById(reservation_id);
        if (reservation.getStatusReservation() == StatusReservation.NEWPAID)
            reservation.setStatusReservation(StatusReservation.CANCELLED);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public boolean beginDate(long reservation_id, long session_id) {
        if (!checkIsAdmin(session_id)) return false;
        Reservation reservation = reservationRepository.getReferenceById(reservation_id);
        if (reservation.getStatusReservation() == StatusReservation.CONFIRMED)
            reservation.setStatusReservation(StatusReservation.DURINGDATE);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public boolean confirmPay(long reservation_id) {
        Reservation reservation = reservationRepository.getReferenceById(reservation_id);
        if (reservation.getStatusReservation() == StatusReservation.NEWUNPAID)
            reservation.setStatusReservation(StatusReservation.NEWPAID);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public boolean endDate(long reservation_id, long session_id) {
        if (!checkIsAdmin(session_id)) return false;
        Reservation reservation = reservationRepository.getReferenceById(reservation_id);
        if (reservation.getStatusReservation() == StatusReservation.DURINGDATE)
            reservation.setStatusReservation(StatusReservation.FINISED);
        reservationRepository.save(reservation);
        return true;
    }

    @Override
    public List<Reservation> getAllReservation(long session_id) {
        if (!checkIsAdmin(session_id)) return null;
        return reservationRepository.findAll();
    }

    private boolean checkIsAdmin(long session_id) {
        try {
            return LoggingService.getPermissions(session_id) == TypeUser.ADMIN;
        } catch (RuntimeException e) {
            return false;
        }
    }

}
