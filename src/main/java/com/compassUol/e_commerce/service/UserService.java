package com.compassUol.e_commerce.service;

import com.compassUol.e_commerce.dto.UserDTO;
import com.compassUol.e_commerce.entities.User;
import com.compassUol.e_commerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    private User getUser(Long id){
        return repository.findById(id).get();
    }
    public void saveUser(User user){
       repository.save(user);
    }

    public List<User> findAll(){
        List<User> users = repository.findAll();
        return users;
    }

    public UserDTO findById(Long id){
        User user = getUser(id);
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

    public UserDTO deleteUserById(Long id){
        User user = getUser(id);
        repository.delete(user);
        return new UserDTO();
    }

}
