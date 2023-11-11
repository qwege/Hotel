package Hotel.Reservation.App.Services;

import Hotel.Reservation.App.Models.Person;
import Hotel.Reservation.App.Models.TypeUser;
import Hotel.Reservation.App.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public boolean register(Person person, long session_id) {
        personRepository.saveAndFlush(person);
        LoggingService.logIn(session_id, person);
        return true;
    }

    @Override
    public boolean login(String login, String password, long session_id) {
        List<Person> list = personRepository.findAll();
        for (Person p : list) {
            if (p.getLogin().equals(login)) {
                if (p.getPassword().equals(password)) {
                    LoggingService.logIn(session_id,p);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean logout(long session_id) {
        LoggingService.logOut(session_id);
        return true;
    }

    @Override
    public TypeUser getStatusOfSession(long session_id) {
        return LoggingService.getPermissions(session_id);
    }

    @Override
    public Person getMyProfile(long session_id) {
        return personRepository.getReferenceById(LoggingService.getPersonIdOfSession(session_id));
    }

    @Override
    public boolean updateProfile(long session_id, Person user) {
        Person person = personRepository.getReferenceById(LoggingService.getPersonIdOfSession(session_id));
        person.setName(user.getName());
        person.setSurname(user.getSurname());
        person.setPassword(user.getPassword());
        person.setLogin(user.getLogin());
        personRepository.save(person);
        return true;
    }

    @Override
    public boolean deleteProfile(long session_id) {
        Person person = personRepository.getReferenceById(LoggingService.getPersonIdOfSession(session_id));
        LoggingService.logOut(session_id);
        personRepository.delete(person);
        return true;
    }


}
