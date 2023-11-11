package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.Person;
import Hotel.Reservation.App.Models.TypeUser;

import java.lang.reflect.Type;

public interface UserService {

    boolean register(Person person, long session_id);
    boolean login(String login, String password,long session_id);
    boolean logout(long session_id);
    TypeUser getStatusOfSession(long session_id);
    Person getMyProfile(long session_id);
    boolean updateProfile(long session_id,Person user);
    boolean deleteProfile(long session_id);


}
