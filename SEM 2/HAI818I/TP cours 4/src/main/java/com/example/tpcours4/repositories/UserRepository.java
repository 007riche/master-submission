package com.example.tpcours4.repositories;

import com.example.tpcours4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
