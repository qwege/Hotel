package Hotel.Reservation;

import Hotel.Reservation.App.Application;
import Hotel.Reservation.App.Controllers.UserController;
import Hotel.Reservation.App.Models.Person;
import Hotel.Reservation.App.Models.TypeUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = Application.class)
class UserTests {
    @Autowired
    UserController userController;


    @Transactional
    @Test
    void register() {
        Person person = new Person();
        person.setLogin("test1");
        person.setName("Test User");
        person.setSurname("User test");
        person.setPassword("TestPassword");
        assert  userController.register(person,12);
    }

    @Transactional
    @Test
    void loginAndLogout() {
        assert userController.login("user","password",5);
        assert userController.logout(5);
    }

    @Transactional
    @Test
    void getStatusOfSession() {
        assert userController.login("user","password",5);
        TypeUser typeUser= userController.getStatusOfSession(5);
        assert (typeUser==TypeUser.USER);

    }

    @Transactional
    @Test
    void getMyProfile() {
        assert userController.login("user","password",5);
        Person p = userController.getMyProfile(5);
        assert p.getId()==1;
    }

    @Transactional
    @Test
    void updateProfile() {
        assert userController.login("user","password",5);
        Person p = userController.getMyProfile(5);
        p.setName("Tested");
        assert userController.updateProfile(5,p);
    }

    @Transactional
    @Test
    void deleteProfile() {
        assert userController.login("user","password",5);
        userController.deleteProfile(5);
        assert !userController.login("user","password",5);
    }
}
