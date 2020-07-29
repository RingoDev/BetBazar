package com.ringodev.server.data.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("users")
public class UserController {


    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/byID/{userID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public User getUser(@PathVariable("userID") String userID) throws Exception {
        return this.repository.findById(userID).orElseThrow(() -> new Exception("User doesn't exist!"));
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }


    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public String addUser(@RequestBody User newUser){
        if(repository.findById(newUser.id).isPresent()) return "User has not successfully been added";
        repository.insert(newUser);
        System.out.println("ADDED USER" + newUser.toString());
        return "User has been added and successfully posted to Spring app";
    }
}
