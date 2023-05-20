package com.bankac.l.k.uygulama3.Controllers;

import com.bankac.l.k.uygulama3.Entity.concretes.User;
import com.bankac.l.k.uygulama3.Repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signIn")
    public String saveUser(@RequestBody User user){
        userRepository.save(user);
        return "User created, user id:" + user.getId();
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/findUser/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return userRepository.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
        return "user deleted with id :" + id;
    }

    /*
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
    */


}
