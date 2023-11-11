package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.Hotel;
import Hotel.Reservation.App.Models.Room;
import Hotel.Reservation.App.Models.TypeUser;
import Hotel.Reservation.App.Repositories.HotelRepository;
import Hotel.Reservation.App.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Room getRoom(long id) {
       return roomRepository.getReferenceById(id);
    }

    @Override
    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }

    @Override
    public boolean CreateRoom(Room room, long hotel_id, long session_id) {
       if(!checkIsAdmin(session_id))return false;
       Hotel hotel =hotelRepository.getReferenceById(hotel_id);
       hotel.getRoom().add(room);
       hotelRepository.save(hotel);
       return true;
    }

    @Override
    public boolean RemoveRoom(long room_id, long session_id) {
        if(!checkIsAdmin(session_id))return false;
        roomRepository.deleteById(room_id);
        return true;
    }

    @Override
    public boolean UpdateRoom(long room_id, Room room, long session_id) {
        if(!checkIsAdmin(session_id))return false;
        Room roomOld = roomRepository.getReferenceById(room_id);
        roomOld.setCity(room.getCity());
        roomOld.setNumber(room.getNumber());
        roomOld.setStreet(room.getStreet());
        roomOld.setDescription(room.getDescription());
        roomRepository.save(roomOld);
        return true;
    }

    @Override
    public Hotel getHotel(long id) {
        return hotelRepository.getReferenceById(id);
    }

    @Override
    public List<Hotel> getHotelList() {
        return hotelRepository.findAll();
    }

    @Override
    public boolean CreateHotel(Hotel hotel, long session_id) {
        if(!checkIsAdmin(session_id))return false;
        hotelRepository.save(hotel);
        return true;
    }

    @Override
    public boolean RemoveHotel(long hotel_id, long session_id) {
        if(!checkIsAdmin(session_id))return false;
        hotelRepository.deleteById(hotel_id);
        return true;
    }

    @Override
    public boolean UpdateHotel(long hotel_id, Hotel hotel, long session_id) {
        if(!checkIsAdmin(session_id))return false;
        Hotel hotelOld = hotelRepository.getReferenceById(hotel_id);
        hotelOld.setName(hotel.getName());
        return true;
    }
    private boolean checkIsAdmin (long session_id){
       return LoggingService.getPermissions(session_id) == TypeUser.ADMIN;
    }
}
