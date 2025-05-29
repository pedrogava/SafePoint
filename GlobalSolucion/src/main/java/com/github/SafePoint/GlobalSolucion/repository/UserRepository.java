package com.github.SafePoint.GlobalSolucion.repository;

import com.github.SafePoint.GlobalSolucion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
