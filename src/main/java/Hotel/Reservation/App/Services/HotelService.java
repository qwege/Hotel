package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.Hotel;
import Hotel.Reservation.App.Models.Room;

import java.util.List;

public interface HotelService {

    Room getRoom(long id);
    List<Room> getRoomList();
    boolean CreateRoom(Room room,long hotel_id,long session_id);
    boolean RemoveRoom(long room_id,long session_id);
    boolean UpdateRoom(long room_id,Room room, long session_id);

    Hotel getHotel(long id);
    List<Hotel> getHotelList();
    boolean CreateHotel(Hotel hotel,long session_id);
    boolean RemoveHotel(long hotel_id,long session_id);
    boolean UpdateHotel(long hotel_id,Hotel hotel, long session_id);


}
