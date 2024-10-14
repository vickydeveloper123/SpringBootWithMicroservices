package com.restapi.RestfullAPIDB.repository;

import com.restapi.RestfullAPIDB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
