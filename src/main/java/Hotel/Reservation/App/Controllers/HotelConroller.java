package Hotel.Reservation.App.Controllers;

import Hotel.Reservation.App.Models.Hotel;
import Hotel.Reservation.App.Models.Room;
import Hotel.Reservation.App.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelConroller {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/room")
    public Room getRoom(@RequestParam long id) {
        return hotelService.getRoom(id);
    }

    @GetMapping("rooms")
    public List<Room> getRoomList() {
        return hotelService.getRoomList();
    }

    @PostMapping("/room")
    public boolean createRoom(@RequestBody Room room, @RequestParam long hotel_id, @RequestParam long session_id) {
        return hotelService.createRoom(room, hotel_id, session_id);

    }

    @DeleteMapping("/room")
    public boolean removeRoom(@RequestParam long room_id, @RequestParam long session_id) {
        return hotelService.removeRoom(room_id, session_id);
    }

    @PutMapping("/room")
    public boolean updateRoom(@RequestParam long room_id, @RequestBody Room room, @RequestParam long session_id) {
        return hotelService.updateRoom(room_id, room, session_id);
    }

    @GetMapping("/hotel")
    public Hotel getHotel(@RequestParam long id) {
        return hotelService.getHotel(id);
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotelList() {
        return hotelService.getHotelList();
    }

    @PostMapping("/hotel")
    public boolean createHotel(@RequestParam Hotel hotel, @RequestParam long session_id) {
        return hotelService.createHotel(hotel, session_id);
    }

    @DeleteMapping("/hotel")
    public boolean removeHotel(@RequestParam long hotel_id, @RequestParam long session_id) {
        return hotelService.removeHotel(hotel_id, session_id);
    }

    @PutMapping("/hotel")
    public boolean updateHotel(@RequestParam long hotel_id, @RequestBody Hotel hotel, @RequestParam long session_id) {
        return hotelService.updateHotel(hotel_id, hotel, session_id);
    }

}
