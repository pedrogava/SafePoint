package com.github.SafePoint.GlobalSolucion.service;


import com.github.SafePoint.GlobalSolucion.dto.UserRequestCreate;
import com.github.SafePoint.GlobalSolucion.dto.UserRequestUpdate;
import com.github.SafePoint.GlobalSolucion.model.User;
import com.github.SafePoint.GlobalSolucion.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> update(Long id,
                                UserRequestUpdate dto) {
        return userRepository.findById(id)
                    .map(user -> {
                        user.setName(dto.getName());
                        user.setEmail(dto.getEmail());
                        user.setPhone(dto.getPhone());
                        return userRepository.save(user);
                    });
    }

    public User save(UserRequestCreate dto) {
                
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    } 
    
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteById(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
