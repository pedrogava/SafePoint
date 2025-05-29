package com.github.SafePoint.GlobalSolucion.repository;

import com.github.SafePoint.GlobalSolucion.model.SupportSession;
import com.github.SafePoint.GlobalSolucion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportSessionRepository extends JpaRepository<SupportSession, Long> {
    List<SupportSession> findByUser(User user);
}
