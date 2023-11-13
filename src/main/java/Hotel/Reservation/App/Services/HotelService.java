package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.Hotel;
import Hotel.Reservation.App.Models.Room;

import java.util.List;

public interface HotelService {

    Room getRoom(long id);
    List<Room> getRoomList();
    boolean createRoom(Room room, long hotel_id, long session_id);
    boolean removeRoom(long room_id, long session_id);
    boolean updateRoom(long room_id, Room room, long session_id);

    Hotel getHotel(long id);
    List<Hotel> getHotelList();
    boolean createHotel(Hotel hotel, long session_id);
    boolean removeHotel(long hotel_id, long session_id);
    boolean updateHotel(long hotel_id, Hotel hotel, long session_id);


}
