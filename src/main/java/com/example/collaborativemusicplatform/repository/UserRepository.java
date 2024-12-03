package com.example.collaborativemusicplatform.repository;

import com.example.collaborativemusicplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
