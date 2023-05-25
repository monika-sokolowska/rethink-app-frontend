package com.example.backend.controller;


import com.example.backend.DTO.LoginDTO;
import com.example.backend.DTO.UserDTO;
import com.example.backend.exceptions.UserNotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "user")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.returnAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO) {

        try {
            User user = userService.getUserByEmail(loginDTO.email());
            if(!user.getPassword().equals(loginDTO.password()))
                throw new UserNotFoundException("User with given password not found.");
            return ResponseEntity.ok(userService.convertUserToUserDTO(user));
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}