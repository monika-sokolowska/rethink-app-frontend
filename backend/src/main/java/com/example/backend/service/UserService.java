package com.example.backend.service;

import com.example.backend.DTO.*;
import com.example.backend.model.Goal;
import com.example.backend.model.OtherFootprint;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> returnAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email)  {
        return userRepository.findByEmail(email);
    }

    public UserDTO changeMainGoalById(Integer id, MainGoalDTO mainGoal)  {
        User user = userRepository.findUserById(id);
        user.setMainGoal(mainGoal.goal());
        userRepository.save(user);

        return convertUserToUserDTO(user);
    }
    public UserDTO findUserById(Integer id)  {

        User user = userRepository.findUserById(id);
        return convertUserToUserDTO(user);
    }


    public UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getMainGoal(),
                user.getIsAdmin()
                );
    }

}
