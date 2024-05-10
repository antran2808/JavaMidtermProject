package com.example.MidTerm.repositories;

import com.example.MidTerm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
