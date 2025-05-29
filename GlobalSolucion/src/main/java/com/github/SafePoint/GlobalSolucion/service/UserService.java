package com.github.SafePoint.GlobalSolucion.service;

import com.github.SafePoint.GlobalSolucion.model.SupportSession;
import com.github.SafePoint.GlobalSolucion.model.User;
import com.github.SafePoint.GlobalSolucion.repository.SupportSessionRepository;
import com.github.SafePoint.GlobalSolucion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SupportSessionRepository supportSessionRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        return userRepository.save(user);
    }

    public List<SupportSession> getSupportHistory(Long userId) {
        User user = getUserById(userId);
        return supportSessionRepository.findByUser(user);
    }
}
