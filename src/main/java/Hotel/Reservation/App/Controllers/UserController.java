package Hotel.Reservation.App.Controllers;

import Hotel.Reservation.App.Models.Person;
import Hotel.Reservation.App.Models.TypeUser;
import Hotel.Reservation.App.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/register")
    public boolean register(@RequestBody Person person,@RequestParam long session_id){
        return userService.register(person,session_id);
    }
    @PutMapping("/login")
    public boolean login(@RequestParam String login,@RequestParam String password,@RequestParam long session_id){
        return userService.login(login, password, session_id);
    }
    @PutMapping("/logout")
    public boolean logout(@RequestParam long session_id){
        return userService.logout(session_id);
    }
    @GetMapping("/type")
    public TypeUser getStatusOfSession(@RequestParam long session_id){
        return userService.getStatusOfSession(session_id);
    }
    @GetMapping("/my")
    public Person getMyProfile(@RequestParam long session_id){
        return userService.getMyProfile(session_id);
    }
    @PostMapping("/update")
    public boolean updateProfile(@RequestParam long session_id,@RequestBody Person user){
        return userService.updateProfile(session_id, user);
    }
    @DeleteMapping("/delete")
    public boolean deleteProfile(long session_id){
        return userService.deleteProfile(session_id);
    }
}
