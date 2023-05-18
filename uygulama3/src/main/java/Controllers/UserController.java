package Controllers;

import Entity.User;
import Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserRepository userRepository;
    @PostConstruct
    public void init(){
        User user= new User();
        user.setId("Çağatay");
        user.setNumber("Yelin");
        user.setPassword("28");

    }

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping

    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }



}
