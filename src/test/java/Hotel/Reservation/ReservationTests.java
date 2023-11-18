package Hotel.Reservation;

import Hotel.Reservation.App.Application;
import Hotel.Reservation.App.Controllers.ReservationController;
import Hotel.Reservation.App.Models.*;
import Hotel.Reservation.App.Services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@SpringBootTest(classes = Application.class)
public class ReservationTests {
    @Autowired
    ReservationController reservationController;
    @Autowired
    UserService userService;

    @BeforeEach
    void loginAdmin() {
        assert  userService.login("admin", "admin", 1);
        assert userService.login("user","password",2);
    }
    @AfterEach
    void logoutAdmin(){
        assert userService.logout(1);
        assert userService.logout(2);
    }

    @Transactional
    @Test
    void getAvaiable(){
        List<Date> dates = reservationController.getAvaiable(0,1);
        assert dates.size()==28;
    }
    @Transactional
    @Test
    void getMyReservation(){
        List<Reservation> reservations = reservationController.getMyReservation(2);
        assert reservations.size()==6;
    }
    @Transactional
    @Test
    void createReservation(){
        List<java.util.Date> dates = new ArrayList<>();
        dates.add(new java.util.Date(System.currentTimeMillis()));
        reservationController.createReservation(10,dates,1);
        List<Reservation> reservations = reservationController.getMyReservation(1);
        assert reservations.size()==1;
    }
    @Transactional
    @Test
    void getReservationByStatus(){
        List<Reservation> reservations = reservationController.getReservationByStatus("CANCELLED",1);
        for (Reservation r: reservations){
            assert r.getStatusReservation() == StatusReservation.CANCELLED;
        }
    }
    @Transactional
    @Test
    void confirmReservation(){
        List<Reservation> reservations = reservationController.getReservationByStatus("NEWPAID",1);
        assert reservations.size()>0;
        Reservation r= reservations.get(0);
        reservationController.confirmReservation(r.getId(),1 );
        List<Reservation> reservations1 = reservationController.getReservationByStatus("CONFIRMED",1);
        for (Reservation res: reservations1){
            if(res.getId()== r.getId())return;
        }
        assert false;
    }
    @Transactional
    @Test
    void cancelReservation(){
        List<Reservation> reservations = reservationController.getReservationByStatus("NEWPAID",1);
        assert reservations.size()>0;
        Reservation r= reservations.get(0);
        reservationController.cancelReservation(r.getId(),1 );
        List<Reservation> reservations1 = reservationController.getReservationByStatus("CANCELLED",1);
        for (Reservation res: reservations1){
            if(res.getId()== r.getId())return;
        }
        assert false;
    }
    @Transactional
    @Test
    void beginDate(){
        List<Reservation> reservations = reservationController.getReservationByStatus("CONFIRMED",1);
        assert reservations.size()>0;
        Reservation r= reservations.get(0);
        reservationController.beginDate(r.getId(),1 );
        List<Reservation> reservations1 = reservationController.getReservationByStatus("DURINGDATE",1);
        for (Reservation res: reservations1){
            if(res.getId()== r.getId())return;
        }
        assert false;
    }
    @Transactional
    @Test
    void confirmPay(){
        List<Reservation> reservations = reservationController.getReservationByStatus("NEWUNPAID",1);
        assert reservations.size()>0;
        Reservation r= reservations.get(0);
        reservationController.confirmPay(r.getId());
        List<Reservation> reservations1 = reservationController.getReservationByStatus("NEWPAID",1);
        for (Reservation res: reservations1){
            if(res.getId()== r.getId())return;
        }
        assert false;
    }
    @Transactional
    @Test
    void endDate(){
        List<Reservation> reservations = reservationController.getReservationByStatus("DURINGDATE",1);
        assert reservations.size()>0;
        Reservation r= reservations.get(0);
        reservationController.endDate(r.getId(),1 );
        List<Reservation> reservations1 = reservationController.getReservationByStatus("FINISED",1);
        for (Reservation res: reservations1){
            if(res.getId()== r.getId())return;
        }
        assert false;
    }
    @Transactional
    @Test
    void getAllReservation(){
        List<Reservation> reservations = reservationController.getAllReservation(1);
        assert  reservations.size() == 6;
    }
}
