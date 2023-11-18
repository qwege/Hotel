package Hotel.Reservation;

import Hotel.Reservation.App.Application;
import Hotel.Reservation.App.Controllers.HotelConroller;
import Hotel.Reservation.App.Models.Hotel;
import Hotel.Reservation.App.Models.Room;

import Hotel.Reservation.App.Services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest(classes = Application.class)
class HotelTests {
    @Autowired
    HotelConroller hotelConroller;
    @Autowired
    UserService userService;

    @BeforeEach
    void loginAdmin() {
        assert  userService.login("admin", "admin", 1);
    }
    @AfterEach
    void logoutAdmin(){
        userService.logout(1);
    }


    @Transactional
    @Test
    void getRoomTest() {
        Room room = hotelConroller.getRoom(3);
        assert room.getNumber() == 3 && room.getCity().equals("City1");
    }

    @Transactional
    @Test
    void createRoomAndGetRoomList()  {
        Room room = new Room();
        room.setDescription("DESC");
        room.setCity("CITY");
        Hotel hotel = hotelConroller.getHotelList().get(0);
        room.setHotel(hotel);
        room.setStreet("STREET");
        room.setDate(new ArrayList<>());
        List<Room> rooms = hotelConroller.getRoomList();
        assert rooms.size() == 19;
        assert hotelConroller.createRoom(room, hotel.getId(), 1);
        rooms = hotelConroller.getRoomList();
        assert rooms.size() == 20;
    }

    @Transactional
    @Test
    void removeRoom() {
        hotelConroller.removeRoom(5, 1);
        try{
        Room r = hotelConroller.getRoom(5);
            r.getStreet().length();
            fail();
        }catch (RuntimeException  e1 ){

        }
    }
    @Transactional
    @Test
    void updateRoom(){
        Room room = hotelConroller.getRoom(7);
        room.setDescription("Test room");
        hotelConroller.updateRoom(7,room,1);
        assert hotelConroller.getRoom(7).getDescription().equals("Test room");
    }
    @Transactional
    @Test
    void getHotel(){
        Hotel hotel = hotelConroller.getHotel(3);
        assert  hotel.getName().equals("Hotel 3*");
    }

    @Transactional
    @Test
    void createHotelAndGetHotelList(){
        List<Hotel> hotels =hotelConroller.getHotelList();
        assert hotels.size()==5;
        Hotel hotel = new Hotel();
        hotel.setName("testHotel");
        hotelConroller.createHotel(hotel,1);
        assert hotelConroller.getHotelList().size() == 6;
    }
    @Transactional
    @Test
    void removeHotel() {
        hotelConroller.removeHotel(5, 1);
        try{
            Hotel h = hotelConroller.getHotel(5);
            h.getName().length();
            fail();
        }catch (RuntimeException  e1 ){

        }
    }

    @Transactional
    @Test
    void updateHotel(){
        Hotel hotel = hotelConroller.getHotel(1);
        hotel.setName("Test Hotel");
        hotelConroller.updateHotel(1,hotel,1);
        assert hotelConroller.getHotel(1).getName().equals("Test Hotel");
    }


}
