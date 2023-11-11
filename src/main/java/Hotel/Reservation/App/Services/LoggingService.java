package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.Person;
import Hotel.Reservation.App.Models.TypeUser;

import java.util.ArrayList;

public class LoggingService {
    private static ArrayList<LoggingData> loggingData = new ArrayList<>();

    protected  static long  getPersonIdOfSession(long session_id){
        for(LoggingData data: loggingData){
            if(data.session_id == session_id) return data.person.getId();
        }
        throw new RuntimeException("Person can`t be find for session "+ session_id);
    }
    protected static boolean logIn(long session_id, Person person_id){
        loggingData.add(new LoggingData(session_id,person_id));
        return true;
    }
    protected static TypeUser getPermissions(long session_id){
        for(LoggingData data: loggingData){
            if(data.session_id == session_id)
                return data.person.getPermissions();
        }
        throw new RuntimeException("Person can`t be find for session "+ session_id);
    }
    protected static boolean logOut(long session_id){
        for(LoggingData data: loggingData){
            if(data.session_id == session_id)
                loggingData.remove(data);
                return true;
        }
        return false;
    }
}
class LoggingData{
    long session_id;
    Person person;

     LoggingData(long session_id, Person person) {
        this.session_id = session_id;
        this.person = person;
    }
}
