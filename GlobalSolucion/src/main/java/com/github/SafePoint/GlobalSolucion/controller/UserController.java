package com.github.SafePoint.GlobalSolucion.controller;

import com.github.SafePoint.GlobalSolucion.model.User;
import com.github.SafePoint.GlobalSolucion.model.SupportSession;
import com.github.SafePoint.GlobalSolucion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST /users - Criar usuário
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // GET /users/{id} - Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // PUT /users/{id} - Atualizar dados do usuário
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    // GET /users/{id}/support-history - Histórico de sessões
    @GetMapping("/{id}/support-history")
    public ResponseEntity<List<SupportSession>> getSupportHistory(@PathVariable Long id) {
        List<SupportSession> history = userService.getSupportHistory(id);
        return ResponseEntity.ok(history);
    }
}
