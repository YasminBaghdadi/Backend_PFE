package com.example.pfe.Controller;

import com.example.pfe.Entity.User;
import com.example.pfe.Services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projet")
public class UserController {
    @Autowired
    UserInterface userInterface;
    // ajout user//
    @PostMapping("/add")
    public User add(@RequestBody User user) {

        return userInterface.addUser(user);
    }
    //supprimer user//
    @DeleteMapping("/delete/{idUser}")
    public void deleteUser(@PathVariable Long idUser){
        userInterface.deleteUser(idUser);
    }
    // verification password //
    @PostMapping("/addwithconfpassword")
    public String addUserWTCP(@RequestBody User user)
    {
        return userInterface.addUserWTCP(user);
    }

    // VERIFICATION 1 username existe //
    @PostMapping("/username")
    public String addUserWTUN(@RequestBody User user)
    {
        return userInterface.addUserWTUN(user);
    }

    // modifier //
    @PutMapping("/updateuser/{ids}")
    public User updateuser(@PathVariable("ids")Long idUser,@RequestBody User user)
    {
        return userInterface.updateUser(idUser,user);
    }
    @GetMapping("/getAllusers")
    public List<User> getAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userInterface.getAllusers(page, size);
    }


    @GetMapping("getUserById/{idUser}")
    public User getUserById(@PathVariable Long idUser)
    {
        return userInterface.getUser(idUser);
    }
    @GetMapping("getUserByUN/{un}")
    public User getUserByUsername(@PathVariable String un)
    {
        return userInterface.getUserByUsername(un);
    }
}
